package com.shopifyandroidinternchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OptionsModel {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("values")
    @Expose
    private ArrayList<String> values;

    public String getName() {
        return name;
    }

    public ArrayList<String> getValues() {
        return values;
    }
}
