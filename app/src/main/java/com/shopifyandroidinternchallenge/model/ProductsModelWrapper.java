package com.shopifyandroidinternchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProductsModelWrapper {
    @SerializedName("collects")
    @Expose
    private ArrayList<ProductsModel> products;

    public ArrayList<ProductsModel> getProducts() {
        return products;
    }
}
