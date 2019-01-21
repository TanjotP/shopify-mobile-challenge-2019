package com.shopifyandroidinternchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CustomCollectionsModel {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("handle")
    @Expose
    private String handle;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("body_html")
    @Expose
    private String bodyHtml;

    @SerializedName("published_at")
    @Expose
    private String publishedAt;

    @SerializedName("template_suffix")
    @Expose
    private String templateSuffix;

    @SerializedName("sort_order")
    @Expose
    private String sortOrder;

    @SerializedName("published_scope")
    @Expose
    private String publishedScope;

    @SerializedName("admin_graphql_api_id")
    @Expose

    private String adminGraphApiId;

    @SerializedName("image")
    @Expose
    private ImageModel image;

    public Long getId() {
        return id;
    }

    public String getHandle() {
        return handle;
    }

    public String getTitle() {
        return title;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getBodyHtml() {
        return bodyHtml;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getTemplateSuffix() {
        return templateSuffix;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public String getPublishedScope() {
        return publishedScope;
    }

    public String getAdminGraphApiId() {
        return adminGraphApiId;
    }

    public ImageModel getImage() {
        return image;
    }
}
