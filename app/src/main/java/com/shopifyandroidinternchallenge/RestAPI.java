package com.shopifyandroidinternchallenge;

import com.shopifyandroidinternchallenge.model.CollectsModelWrapper;
import com.shopifyandroidinternchallenge.model.CustomCollectionsModelWrapper;
import com.shopifyandroidinternchallenge.model.ProductsModelWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RestAPI {
    //CustomCollections
    @GET("custom_collections.json?")
    Call<CustomCollectionsModelWrapper> getCustomCollectionsPosts(@Query("page") String pgNum, @Query("access_token") String access);

    //middleware collects api
    @GET("collects.json?")
    Call<CollectsModelWrapper> getCollectsPosts(@Query("collection_id") String collectionsID,
                                                @Query("page") String pgNum, @Query("access_token") String access);

    //Products
    @GET("products.json?")
    Call<ProductsModelWrapper> getProductsPost(@Query("ids")String productsID,
                                               @Query("page") String pgNum, @Query("access_token") String access);

}
