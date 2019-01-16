package com.shopifyandroidinternchallenge;

import com.shopifyandroidinternchallenge.model.CollectsModelWrapper;
import com.shopifyandroidinternchallenge.model.CustomCollectionsModel;
import com.shopifyandroidinternchallenge.model.CustomCollectionsModelWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestAPI {
    @GET("custom_collections.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    Call<CustomCollectionsModelWrapper> getCustomCollectionsPosts();

    @GET("collects.json?collection_id=68424466488&page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    Call<CollectsModelWrapper> getCollectsPosts();

}
