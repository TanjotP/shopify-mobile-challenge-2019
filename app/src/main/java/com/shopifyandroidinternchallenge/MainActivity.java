package com.shopifyandroidinternchallenge;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.shopifyandroidinternchallenge.adapter.CustomCollectionsAdapter;
import com.shopifyandroidinternchallenge.fragment.CustomCollectionsListPageFragment;
import com.shopifyandroidinternchallenge.model.CollectsModel;
import com.shopifyandroidinternchallenge.model.CollectsModelWrapper;
import com.shopifyandroidinternchallenge.model.CustomCollectionsModel;
import com.shopifyandroidinternchallenge.model.CustomCollectionsModelWrapper;
import com.shopifyandroidinternchallenge.model.ProductsModel;
import com.shopifyandroidinternchallenge.model.ProductsModelWrapper;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String BASE_URL = "https://shopicruit.myshopify.com/admin/";
    private RecyclerView recyclerView;
    private ArrayList<CustomCollectionsModelWrapper> data;
    private CustomCollectionsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadJSON();
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestAPI request = retrofit.create(RestAPI.class);

        Call<CustomCollectionsModelWrapper> callCustomCollections = request.getCustomCollectionsPosts();

        callCustomCollections.enqueue(new Callback<CustomCollectionsModelWrapper>() {
            @Override
            public void onResponse(Call<CustomCollectionsModelWrapper> call, Response<CustomCollectionsModelWrapper> response) {
                Log.d(TAG, "onResponse: Server Response: " + response.toString());
                Log.d(TAG, "onResponse: received information: " + response.body().toString());
                //TODO: null check for reponse body
                ArrayList<CustomCollectionsModel> data = response.body().getCustomCollections();
                //start fragment after map completed
                goToFragment(CustomCollectionsListPageFragment.newInstance(data));
                /*for( int i = 0; i<data.size(); i++){
                    Log.d(TAG, "onResponse: \n" +
                            "title: " + data.get(i).getTitle() + "\n" +
                            "handle: " + data.get(i).getHandle() + "\n" +
                            "updateat: " + data.get(i).getUpdatedAt() + "\n" +
                            "-------------------------------------------------------------------------\n\n");
                }*/
            }

            @Override
            public void onFailure(Call<CustomCollectionsModelWrapper> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

        Call<CollectsModelWrapper> callCollects = request.getCollectsPosts();

        callCollects.enqueue(new Callback<CollectsModelWrapper>() {
            @Override
            public void onResponse(Call<CollectsModelWrapper> call, Response<CollectsModelWrapper> response) {
                //TODO: null check for response body
                Log.d(TAG, "onResponse: Server Response: " + response.toString());
                Log.d(TAG, "onResponse: received information: " + response.body().toString());
                ArrayList<CollectsModel> data = response.body().getCollects();
                /*for( int i = 0; i<data.size(); i++){
                    Log.d(TAG, "onResponse: \n" +
                            "title: " + data.get(i).getCollectionId() + "\n" +
                            "handle: " + data.get(i).getFeatured() + "\n" +
                            "updateat: " + data.get(i).getCreatedAt() + "\n" +
                            "-------------------------------------------------------------------------\n\n");
                }*/
            }

            @Override
            public void onFailure(Call<CollectsModelWrapper> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

        Call<ProductsModelWrapper> callProducts = request.getProductsPost();

        callProducts.enqueue(new Callback<ProductsModelWrapper>() {
            @Override
            public void onResponse(Call<ProductsModelWrapper> call, Response<ProductsModelWrapper> response) {
                //TODO: null check for response body
                Log.d(TAG, "onResponse: Server Response: " + response.toString());
                Log.d(TAG, "onResponse: received information: " + response.body().toString());
                ArrayList<ProductsModel> data = response.body().getProducts();
                /*for( int i = 0; i<data.size(); i++){
                    Log.d(TAG, "onResponse: \n" +
                            "title: " + data.get(i).getImage().getSrc() + "\n" +
                            "handle: " + data.get(i).getTitle() + "\n" +
                            "updateat: " + data.get(i).getTags() + "\n" +
                            "-------------------------------------------------------------------------\n\n");
                }*/
            }

            @Override
            public void onFailure(Call<ProductsModelWrapper> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }

    public void goToFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentHolder, fragment);
        fragmentTransaction.commit();
    }

}

