package com.shopifyandroidinternchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.shopifyandroidinternchallenge.adapter.CustomCollectionsAdapter;
import com.shopifyandroidinternchallenge.model.CustomCollectionsModel;
import com.shopifyandroidinternchallenge.model.CustomCollectionsModelWrapper;

import java.util.ArrayList;
import java.util.Arrays;

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

        initViews();
    }

    private void initViews() {
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
//                .baseUrl("https://earthquake.usgs.gov/fdsnws/event/1/query?")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestAPI request = retrofit.create(RestAPI.class);
        Call<CustomCollectionsModelWrapper> call = request.getCustomCollectionsPosts();

        call.enqueue(new Callback<CustomCollectionsModelWrapper>() {
            @Override
            public void onResponse(Call<CustomCollectionsModelWrapper> call, Response<CustomCollectionsModelWrapper> response) {
                Log.d(TAG, "onResponse: Server Response: " + response.toString());
                Log.d(TAG, "onResponse: received information: " + response.body().toString());

                ArrayList<CustomCollectionsModel> data = response.body().getCustomCollections();
                adapter = new CustomCollectionsAdapter(data);
                recyclerView.setAdapter(adapter);
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
    }
}

