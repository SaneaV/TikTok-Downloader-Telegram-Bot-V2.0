package com.tiktok.downloader.repository;

import com.tiktok.downloader.domain.TikTokVideo;

public interface TikTokDownloaderRepository {

    TikTokVideo getVideo(String videoLink);
}
