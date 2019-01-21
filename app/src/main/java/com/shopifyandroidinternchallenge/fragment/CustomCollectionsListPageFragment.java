package com.shopifyandroidinternchallenge.fragment;

import android.content.Context;
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
import android.widget.Toast;

import com.shopifyandroidinternchallenge.MainActivity;
import com.shopifyandroidinternchallenge.R;
import com.shopifyandroidinternchallenge.adapter.CustomCollectionsAdapter;
import com.shopifyandroidinternchallenge.model.CollectsModel;
import com.shopifyandroidinternchallenge.model.CustomCollectionsModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomCollectionsListPageFragment extends Fragment {
    private OnFragmentListener mListener;
    private ArrayList<CustomCollectionsModel> customCollectionData;
    private RecyclerView mRecyclerView;
    private CustomCollectionsAdapter mAdapter;
    private Long interJoinId;

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
        return inflater.inflate(R.layout.custom_collections_list_page, container, false);    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = view.findViewById(R.id.card_recycler_view);
        mAdapter = new CustomCollectionsAdapter(customCollectionData ,mListener);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentListener) {
            mListener = (OnFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentListener {
        void goOnMoreDetailsPage(Long interJoinId);
    }


}