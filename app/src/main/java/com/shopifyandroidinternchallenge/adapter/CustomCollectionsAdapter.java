package com.shopifyandroidinternchallenge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.shopifyandroidinternchallenge.R;
import com.shopifyandroidinternchallenge.model.CustomCollectionsModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomCollectionsAdapter extends RecyclerView.Adapter<CustomCollectionsAdapter.ViewHolder> {
    private Context context;

    private ArrayList<CustomCollectionsModel> android;
    private RecyclerViewClickListener mListener;

    public CustomCollectionsAdapter(ArrayList<CustomCollectionsModel> android, RecyclerViewClickListener listener) {
        this.android = android;
        this.context = context;
        mListener = listener;

    }

    @Override
    public CustomCollectionsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row,parent,false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(CustomCollectionsAdapter.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder rowHolder = (ViewHolder) holder;
            //set values of data here
            holder.mTitle.setText(android.get(position).getTitle());
            holder.mSortOrder.setText(android.get(position).getSortOrder());
            holder.mUpdateAt.setText(android.get(position).getUpdatedAt());
            Picasso.get().load(android.get(position).getImage().getSrc()).into(holder.mImage);
        }
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitle;
        private TextView mSortOrder;
        private TextView mUpdateAt;
        private ImageView mImage;
        private RecyclerViewClickListener mListener;


        public ViewHolder(View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            context = itemView.getContext();
            mListener = listener;
            mTitle = (TextView)itemView.findViewById(R.id.tv_name);
            mSortOrder = (TextView)itemView.findViewById(R.id.tv_version);
            mUpdateAt = (TextView)itemView.findViewById(R.id.tv_api_level);
            mImage = (ImageView)itemView.findViewById(R.id.image_view);
            itemView.setOnClickListener(this);



        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }


    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

}