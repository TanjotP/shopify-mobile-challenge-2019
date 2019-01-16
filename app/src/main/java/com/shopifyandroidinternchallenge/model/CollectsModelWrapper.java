package com.shopifyandroidinternchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CollectsModelWrapper {
    @SerializedName("collects")
    @Expose
    private ArrayList<CollectsModel> customCollects;
}
