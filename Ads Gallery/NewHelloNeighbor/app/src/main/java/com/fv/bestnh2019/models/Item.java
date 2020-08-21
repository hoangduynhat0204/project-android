package com.fv.bestnh2019.models;

import java.io.Serializable;

public class Item implements Serializable {
    private int imageResourceId;
    private String title;
    private String content;
    private int detailResourceId;

    public Item(int imageResourceId, String title, String content, int detailResourceId) {
        this.imageResourceId = imageResourceId;
        this.title = title;
        this.content = content;
        this.detailResourceId = detailResourceId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDetailResourceId() {
        return detailResourceId;
    }

    public void setDetailResourceId(int detailResourceId) {
        this.detailResourceId = detailResourceId;
    }
}
