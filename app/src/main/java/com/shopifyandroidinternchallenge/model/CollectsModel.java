package com.shopifyandroidinternchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CollectsModel {
    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("collection_id")
    @Expose
    private Long collectionId;

    @SerializedName("product_id")
    @Expose
    private Long productId;

    @SerializedName("featured")
    @Expose
    private String featured;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    public Long getId() {
        return id;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public Long getProductId() {
        return productId;
    }

    public String getFeatured() {
        return featured;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getPosition() {
        return position;
    }

    public String getSort_value() {
        return sort_value;
    }

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
