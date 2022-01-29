package com.tiktok.downloader.service.impl;

import com.tiktok.downloader.domain.TikTokVideo;
import com.tiktok.downloader.repository.TikTokDownloaderRepository;
import com.tiktok.downloader.service.TikTokDownloaderService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static com.tiktok.downloader.bot.utils.MessageUtils.sendVideo;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class TikTokDownloaderServiceImpl implements TikTokDownloaderService {

    private static final String PATH_NAME = "Video.mp4";
    private static final String MESSAGE_TEXT = "Girl's TikTok account - [%s](https://www.tiktok.com/%s)\n\n" +
            "Instagram [Chisinau_Girls](https://www.instagram.com/chisinau_girls/)";

    private final TikTokDownloaderRepository tikTokDownloaderRepository;

    @Override
    public SendVideo sendTikTok(Update update) throws IOException {
        final Message message = update.getMessage();
        final TikTokVideo tikTokVideo = tikTokDownloaderRepository.getVideo(message.getText());
        final String formattedMessage = format(MESSAGE_TEXT, tikTokVideo.getAuthorUniqueId(), tikTokVideo.getAuthorUniqueId());

        final URL url = new URL(tikTokVideo.getVideoDownloadAddress());
        final File file = new File(PATH_NAME);
        FileUtils.copyURLToFile(url, file);
        final InputFile inputFile = new InputFile(file);

        return sendVideo(message, formattedMessage, inputFile);
    }
}
