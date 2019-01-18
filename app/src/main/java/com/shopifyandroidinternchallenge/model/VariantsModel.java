package com.shopifyandroidinternchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VariantsModel {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("inventory_quantity")
    @Expose
    private int inventoryQuantity;


    public String getTitle() {
        return title;
    }

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }
}
