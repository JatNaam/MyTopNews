package com.example.mytopnews.newstypelist;

public class NewsType {
    private String name;

    private int imageId;

    public NewsType(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
