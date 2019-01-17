package com.shopifyandroidinternchallenge.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shopifyandroidinternchallenge.model.CollectsModel;

import java.util.ArrayList;

public class CollectsDetailsPageFragment extends Fragment {
    private ArrayList<CollectsModel> collectsData;
    private RecyclerView mRecyclerView;

    public CollectsDetailsPageFragment() {
    }

    public static CollectsDetailsPageFragment newInstance(ArrayList<CollectsModel> collectsData) {
        CollectsDetailsPageFragment fragment = new CollectsDetailsPageFragment();
        fragment.collectsData = collectsData;
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
