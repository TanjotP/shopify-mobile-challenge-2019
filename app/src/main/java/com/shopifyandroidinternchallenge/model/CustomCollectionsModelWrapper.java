package com.shopifyandroidinternchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CustomCollectionsModelWrapper {

    @SerializedName("custom_collections")
    @Expose
    private ArrayList<CustomCollectionsModel> customCollections;

    public ArrayList<CustomCollectionsModel> getCustomCollections() {
        return customCollections;
    }
}
