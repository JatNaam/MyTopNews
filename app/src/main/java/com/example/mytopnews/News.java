package com.example.mytopnews;

public class News {
    private final int imageId;

    private final String newsTitle;
    private final String newsURL;
    private final String newsTime;
    private final String URL;

    public News(int imageId, String newsTitle, String newsURL, String newsTime, String URL) {
        this.imageId = imageId;
        this.newsTitle = newsTitle;
        this.newsURL = newsURL;
        this.newsTime = newsTime;
        this.URL = URL;
    }

    public int getImageId() {
        return imageId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsURL() {
        return newsURL;
    }

    public String getNewsTime() {
        return newsTime;
    }

    public String getURL() {
        return URL;
    }

}
