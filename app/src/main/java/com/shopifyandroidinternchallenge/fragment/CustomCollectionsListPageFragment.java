package com.shopifyandroidinternchallenge.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shopifyandroidinternchallenge.R;
import com.shopifyandroidinternchallenge.adapter.CustomCollectionsAdapter;
import com.shopifyandroidinternchallenge.model.CustomCollectionsModel;

import java.util.ArrayList;

public class CustomCollectionsListPageFragment extends Fragment {
    private ArrayList<CustomCollectionsModel> customCollectionData;
    private RecyclerView mRecyclerView;

    public CustomCollectionsListPageFragment() {
    }

    public static CustomCollectionsListPageFragment newInstance(ArrayList<CustomCollectionsModel> customCollectionData) {
        CustomCollectionsListPageFragment fragment = new CustomCollectionsListPageFragment();
        fragment.customCollectionData = customCollectionData;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.custom_collections_list_page, container, false);
        mRecyclerView =  (RecyclerView) v.findViewById(R.id.card_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        CustomCollectionsAdapter.RecyclerViewClickListener listener = (view, position) -> {
            Toast.makeText(getContext(), "Position " + position, Toast.LENGTH_SHORT).show();
        };
        CustomCollectionsAdapter mAdapter = new CustomCollectionsAdapter(customCollectionData, listener );
        mRecyclerView.setAdapter(mAdapter);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        //adapter.addOrders2017(ordersIn2017);
    }
}