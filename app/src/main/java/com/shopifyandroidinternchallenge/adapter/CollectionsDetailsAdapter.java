package com.shopifyandroidinternchallenge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shopifyandroidinternchallenge.R;
import com.shopifyandroidinternchallenge.model.ProductsModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CollectionsDetailsAdapter extends RecyclerView.Adapter<CollectionsDetailsAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ProductsModel> mProductsData;

    public CollectionsDetailsAdapter(ArrayList<ProductsModel> data) {
        this.mProductsData = data;
        this.context = context;
    }

    @Override
    public CollectionsDetailsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.collections_details_page_card_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CollectionsDetailsAdapter.ViewHolder holder, int position) {
        holder.mProductTitle.setText(mProductsData.get(position).getTitle());
        holder.mInventoryText.setText(totalInventory(position));
        //holder.mCollectionTitle.setText(android.get(position).get);
        Picasso.get().load(mProductsData.get(position).getImage().getSrc()).into(holder.mCollectionImage);
    }

    @Override
    public int getItemCount() {
        return mProductsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mProductTitle;
        private TextView mInventoryText;
        private TextView mCollectionTitle;
        private ImageView mCollectionImage;


        public ViewHolder(View itemView){
            super(itemView);
            context = itemView.getContext();
            mProductTitle = (TextView)itemView.findViewById(R.id.productTitleText);
            mInventoryText = (TextView)itemView.findViewById(R.id.inventoryText);
            mCollectionTitle = (TextView)itemView.findViewById(R.id.collectionTitleText);
            mCollectionImage = (ImageView)itemView.findViewById(R.id.collectionImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //no-op
                }
            });

        }
    }

    private String totalInventory(int mPos){
        int sum=0;
        for(int i = 0; i < mProductsData.get(mPos).getVariants().size(); i++){
            sum += mProductsData.get(mPos).getVariants().get(i).getInventoryQuantity();
        }
        return Integer.toString(sum);
    }
}