package com.example.mytopnews.Content;

// news list item
public class News {
    // 图片R.id
    private final int imageId;
    // 新闻标题
    private final String newsTitle;
    // 新闻网站的域名
    private final String newsURL;
    // 新闻的发表时间
    private final String newsTime;
    // 新闻的网址URL
    private final String URL;

    /**
     * construct、 getter and setter
     */

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
