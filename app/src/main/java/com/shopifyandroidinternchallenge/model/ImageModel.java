package com.shopifyandroidinternchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageModel {

    @Expose
    @SerializedName("created_at")
    private String createdAt;

    @Expose
    @SerializedName("alt")
    private String alt;

    @Expose
    @SerializedName("width")
    private int width;

    @Expose
    @SerializedName("height")
    private int height;

    @Expose
    @SerializedName("src")
    private String src;

    public String getCreatedAt() {
        return createdAt;
    }

    public String getAlt() {
        return alt;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getSrc() {
        return src;
    }
}
