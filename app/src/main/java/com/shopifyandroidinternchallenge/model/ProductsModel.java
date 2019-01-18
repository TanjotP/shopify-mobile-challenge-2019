package com.shopifyandroidinternchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProductsModel {

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("body_html")
    @Expose
    private String bodyHtml;

    @SerializedName("vendor")
    @Expose
    private String vendor;

    @SerializedName("product_type")
    @Expose
    private String productType;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("tags")
    @Expose
    private String tags;

    @SerializedName("variants")
    @Expose
    private ArrayList<VariantsModel> variants;

    @SerializedName("image")
    @Expose
    private ImageModel image;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBodyHtml() {
        return bodyHtml;
    }

    public String getVendor() {
        return vendor;
    }

    public String getProductType() {
        return productType;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getTags() {
        return tags;
    }

    public ImageModel getImage() {
        return image;
    }

    public ArrayList<VariantsModel> getVariants() {
        return variants;
    }
}
