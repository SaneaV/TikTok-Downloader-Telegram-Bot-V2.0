package com.tiktok.downloader.service;

import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

public interface TikTokDownloaderService {

    SendVideo sendTikTok(Update update) throws IOException;
}
