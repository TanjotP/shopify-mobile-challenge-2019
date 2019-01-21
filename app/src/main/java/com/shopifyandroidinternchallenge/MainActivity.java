package com.shopifyandroidinternchallenge;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.shopifyandroidinternchallenge.fragment.CollectionsDetailsPageFragment;
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

public class MainActivity extends AppCompatActivity implements CustomCollectionsListPageFragment.OnFragmentListener {
    private static final String TAG = "MainActivity";
    private static final String BASE_URL = "https://shopicruit.myshopify.com/admin/";
    private final String ACCESS_TOKEN = "c32313df0d0ef512ca64d5b336a0d7c6";
    private final String PAGE_NUMBER = "1";
    //new arraylist for safety on null pointers
    private ArrayList<CustomCollectionsModel> customCollectionsData = new ArrayList<>();
    private ArrayList<CollectsModel> collectsData = new ArrayList<>();
    private ArrayList<ProductsModel> productsArrayData = new ArrayList<>();
    private ArrayList<ProductsModel> filteredProductsArrayData = new ArrayList<>();
    String productsId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RestAPI request = retrofit.create(RestAPI.class);
        loadCustomCollections(request); //dependency of these calls on RESTAPI interface
        loadCollects(request);  //no injection used
        loadProducts(request);

    }

    private void loadCustomCollections(RestAPI request) {

        Call<CustomCollectionsModelWrapper> callCustomCollections = request.getCustomCollectionsPosts(PAGE_NUMBER, ACCESS_TOKEN);

        callCustomCollections.enqueue(new Callback<CustomCollectionsModelWrapper>() {
            @Override
            public void onResponse(Call<CustomCollectionsModelWrapper> call, Response<CustomCollectionsModelWrapper> response) {
                Log.d(TAG, "onResponse: Server Response: " + response.toString());
                Log.d(TAG, "onResponse: received information: " + response.body().toString());
                if(!response.isSuccessful()){ //response, but not successful
                    return;
                }
                customCollectionsData = response.body().getCustomCollections();
                //call new fragment setup with current dataset
                goToFragment(CustomCollectionsListPageFragment.newInstance(customCollectionsData));
            }
            @Override
            public void onFailure(Call<CustomCollectionsModelWrapper> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }

    public void loadCollects(RestAPI request){
        Call<CollectsModelWrapper> callCollects = request.getCollectsPosts("68424466488",PAGE_NUMBER, ACCESS_TOKEN);

        callCollects.enqueue(new Callback<CollectsModelWrapper>() {
            @Override
            public void onResponse(Call<CollectsModelWrapper> call, Response<CollectsModelWrapper> response) {
                Log.d(TAG, "onResponse: Server Response: " + response.toString());
                Log.d(TAG, "onResponse: received information: " + response.body().toString());
                if(!response.isSuccessful()){ //response, but not successful
                    return;
                }
                collectsData = response.body().getCollects();
            }

            @Override
            public void onFailure(Call<CollectsModelWrapper> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }

    public void loadProducts(RestAPI request){
        //TODO: left as string to replace with "productsId" in case for dynamic url, functionality exists already
        Call<ProductsModelWrapper> callProducts = request.getProductsPost("2759137027,2759143811",
                PAGE_NUMBER, ACCESS_TOKEN);

        callProducts.enqueue(new Callback<ProductsModelWrapper>() {
            @Override
            public void onResponse(Call<ProductsModelWrapper> call, Response<ProductsModelWrapper> response) {
                Log.d(TAG, "onResponse: Server Response: " + response.toString());
                Log.d(TAG, "onResponse: received information: " + response.body().toString());
                if(!response.isSuccessful()){ //response, but not successful
                    return;
                }
                productsArrayData = response.body().getProducts();
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

    public void queryFilter(Long interJoinID){ //used to filter data specific for specific collection
        Log.d(TAG, "heres interJoin: "+interJoinID);
        ArrayList<Long> firstMiddleWare =  new ArrayList<>();

        for (int i = 0; i < collectsData.size(); i++){ //checking if collections ID match
            if(interJoinID.equals((collectsData.get(i).getCollectionId()))){
                firstMiddleWare.add(collectsData.get(i).getProductId());
            }
        }

        for (int i = 0; i < firstMiddleWare.size(); i++){ //specific collecition ids mapped to product ids
            for (int j = 0; j < productsArrayData.size(); j++){
                if((productsArrayData.get(j).getId()).equals(firstMiddleWare.get(i))){
                    filteredProductsArrayData.add(productsArrayData.get(j)); //returned as filtered data
                    productsId += Long.toString(firstMiddleWare.get(i)) +","; //made for dynamic url usage
                }
            }
        }
        productsId = removeLastChar(productsId);
    }

    public String removeLastChar(String str) { //to mimick ids of products in URL
        if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == ',') {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    @Override
    public void goOnMoreDetailsPage(Long interJoinId) { //interjoinId = id from collections onClick
        queryFilter(interJoinId);
        goToFragment(CollectionsDetailsPageFragment.newInstance(filteredProductsArrayData)); //send filtereddata to new frag
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}

