package com.tiktok.downloader.repository.impl;

import com.tiktok.downloader.domain.TikTokVideo;
import com.tiktok.downloader.parser.TikTokDownloaderParser;
import com.tiktok.downloader.repository.TikTokDownloaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.format;

@Repository
@RequiredArgsConstructor
public class TikTokDownloaderRepositoryImpl implements TikTokDownloaderRepository {

    private static final String DOWNLOAD_LINK = "https://s6.youtube4kdownloader.com/ajax/getLinks.php?video=%s&rand=da5e975d989b6";
    private static final String TIK_TOK_PATTERN = "(https://[a-zA-Z]+\\.tiktok\\.com/)(@.+)(/video.+)";

    private final TikTokDownloaderParser tikTokDownloaderParser;
    private final WebClient webClient;

    @Override
    public TikTokVideo getVideo(String videoLink) {
        final String videoLinkDownload = getVideoLink(videoLink);
        final String authorUniqueId = getAuthorUniqueId(videoLink);
        return new TikTokVideo(authorUniqueId, videoLinkDownload);
    }

    public String getVideoLink(String videoLink) {
        final String downloadUrl = getVideoDownloadUrl(videoLink);

        return webClient.get()
                .uri(downloadUrl)
                .retrieve()
                .bodyToMono(String.class)
                .map(tikTokDownloaderParser::parseLink)
                .block();
    }

    private String getVideoDownloadUrl(String videoLink) {
        return format(DOWNLOAD_LINK, videoLink);
    }

    private String getAuthorUniqueId(String videoLink) {
        final Pattern pattern = Pattern.compile(TIK_TOK_PATTERN);
        final Matcher matcher = pattern.matcher(videoLink);

        if (matcher.find()) {
            return matcher.group(2);
        }

        return null;
    }
}

