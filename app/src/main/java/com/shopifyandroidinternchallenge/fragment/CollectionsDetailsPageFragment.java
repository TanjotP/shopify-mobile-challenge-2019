package com.shopifyandroidinternchallenge.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shopifyandroidinternchallenge.model.CollectsModel;
import com.shopifyandroidinternchallenge.model.ProductsModel;

import java.util.ArrayList;

public class CollectionsDetailsPageFragment extends Fragment {
    private static final String TAG = "CollectionsFrag";

    private ArrayList<ProductsModel> productsData;
    private RecyclerView mRecyclerView;

    public CollectionsDetailsPageFragment() {
    }

    public static CollectionsDetailsPageFragment newInstance(ArrayList<ProductsModel> productsData) {
        CollectionsDetailsPageFragment fragment = new CollectionsDetailsPageFragment();
        fragment.productsData = productsData;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
