package com.tiktok.downloader.parser.impl;

import com.tiktok.downloader.parser.TikTokDownloaderParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class TikTokDownloaderParserImpl implements TikTokDownloaderParser {

    @Override
    public String parseLink(String json) {
        final JSONObject videoInfo = getJsonObjectFromString(json);
        return parseToString(videoInfo);
    }

    private JSONObject getJsonObjectFromString(String fullVideoInfo) {
        return new JSONObject(fullVideoInfo);
    }

    private String parseToString(JSONObject json) {
        if (json.isEmpty()) {
            return null;
        } else {
            final JSONArray jsonArray = json.getJSONObject("data").getJSONArray("av");
            final int numberOfSources = jsonArray.length();
            return jsonArray.getJSONObject(numberOfSources - 1).getString("url");
        }
    }
}
