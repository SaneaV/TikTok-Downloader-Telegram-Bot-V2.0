package com.tiktok.downloader.controller;

import com.tiktok.downloader.bot.service.TikTokDownloaderBot;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class WebHookController {

    private final TikTokDownloaderBot tikTokDownloaderBot;

    @PostMapping(value = "/")
    public ResponseEntity<BotApiMethod<?>> onUpdateReceived(@RequestBody Update update) {
        return ok().body(tikTokDownloaderBot.onWebhookUpdateReceived(update));
    }
}
