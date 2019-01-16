package com.shopifyandroidinternchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CollectsModel {
    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("collection_id")
    @Expose
    private String collectionId;

    @SerializedName("product_id")
    @Expose
    private String productId;

    @SerializedName("featured")
    @Expose
    private String featured;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updated_at;

    @SerializedName("position")
    @Expose
    private String position;

    @SerializedName("sort_value")
    @Expose
    private String sort_value;
}