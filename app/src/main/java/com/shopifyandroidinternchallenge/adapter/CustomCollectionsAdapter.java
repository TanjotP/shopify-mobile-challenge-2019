package com.shopifyandroidinternchallenge.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shopifyandroidinternchallenge.R;
import com.shopifyandroidinternchallenge.model.CustomCollectionsModel;

import java.util.ArrayList;

public class CustomCollectionsAdapter extends RecyclerView.Adapter<CustomCollectionsAdapter.ViewHolder> {

    private ArrayList<CustomCollectionsModel> android;

    public CustomCollectionsAdapter(ArrayList<CustomCollectionsModel> android) {
        this.android = android;
    }

    @Override
    public CustomCollectionsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomCollectionsAdapter.ViewHolder holder, int position) {
        holder.mTitle.setText(android.get(position).getTitle());
        holder.mSortOrder.setText(android.get(position).getSortOrder());
        holder.mUpdateAt.setText(android.get(position).getUpdatedAt());
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mSortOrder;
        private TextView mUpdateAt;

        public ViewHolder(View itemView) {
            super(itemView);

            mTitle = (TextView)itemView.findViewById(R.id.tv_name);
            mSortOrder = (TextView)itemView.findViewById(R.id.tv_version);
            mUpdateAt = (TextView)itemView.findViewById(R.id.tv_api_level);

        }
    }
}