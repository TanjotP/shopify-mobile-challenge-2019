package com.shopifyandroidinternchallenge;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CustomCollectionsListPage {

    @SerializedName("custom_collections")
    @Expose
    private List<CustomCollectionsListPage> customCollections;

    @SerializedName("id")
    @Expose
    private long id;

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

    @Expose
    @SerializedName("published_at")
    private String publishedAt;

    @Expose
    @SerializedName("template_suffix")
    private String templateSuffix;

    @Expose
    @SerializedName("sort_order")
    private String sortOrder;

    @Expose
    @SerializedName("published_scope")
    private String publishedScope;

    @Expose
    @SerializedName("admin_graphql_api_id")
    private String adminGraphApiId;

    public long getId() {
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
}
