package com.tiktok.downloader.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TikTokVideo {

    private final String authorUniqueId;
    private final String videoDownloadAddress;
}
