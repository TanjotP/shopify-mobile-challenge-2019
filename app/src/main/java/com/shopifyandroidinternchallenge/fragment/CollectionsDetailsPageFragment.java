package com.shopifyandroidinternchallenge.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shopifyandroidinternchallenge.R;
import com.shopifyandroidinternchallenge.adapter.ProductsAdapter;
import com.shopifyandroidinternchallenge.model.ProductsModel;

import java.util.ArrayList;

public class CollectionsDetailsPageFragment extends Fragment {
    private static final String TAG = "CollectionsFrag";
    private ArrayList<ProductsModel> productsData;
    private RecyclerView mRecyclerView;
    ProductsAdapter mAdapter;

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
        return inflater.inflate(R.layout.collections_details_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.card_recycler_view);
        mAdapter = new ProductsAdapter(productsData);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
    }

}
