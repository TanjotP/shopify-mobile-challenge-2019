package com.shopifyandroidinternchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VariantsModelWrapper {
    @SerializedName("variants")
    @Expose
    private ArrayList<VariantsModel> variants;

    public ArrayList<VariantsModel> getVariants() {
        return variants;
    }
}
