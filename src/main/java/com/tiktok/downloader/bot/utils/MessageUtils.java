package com.tiktok.downloader.bot.utils;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;

import static org.telegram.telegrambots.meta.api.methods.ParseMode.MARKDOWN;

public class MessageUtils {

    public static SendMessage sendMessage(Message message, String text) {
        final String chatId = message.getChatId().toString();
        return SendMessage.builder()
                .chatId(chatId)
                .parseMode(MARKDOWN)
                .text(text)
                .build();
    }

    public static SendVideo sendVideo(Message message, String text, InputFile inputFile) {
        final String chatId = message.getChatId().toString();
        return SendVideo.builder()
                .caption(text)
                .video(inputFile)
                .chatId(chatId)
                .parseMode(MARKDOWN)
                .build();
    }

    public static SendMessage sendMessageError(Message message, String text) {
        return sendMessage(message, text);
    }
}
