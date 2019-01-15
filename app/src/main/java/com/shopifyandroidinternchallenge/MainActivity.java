package com.shopifyandroidinternchallenge;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.test);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://shopicruit.myshopify.com/admin/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestAPI jsonRestApi = retrofit.create(RestAPI.class);

        Call<CustomCollectionsListPage> call = jsonRestApi.getPosts();

        call.enqueue(new Callback<CustomCollectionsListPage>() {
            @Override
            public void onResponse(Call<CustomCollectionsListPage> call, Response<CustomCollectionsListPage> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                    return;
                }

                CustomCollectionsListPage p = response.body();
                textView.setText("yay");

                /*List<CustomCollectionsListPage> posts = response.body();
                for(CustomCollectionsListPage post : posts){
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "TITLE: " + post.getTitle() + "\n";
                    content += "SORT: " + post.getSortOrder() + "\n\n";
                    textView.append(content);
                }*/
            }

            @Override
            public void onFailure(Call<CustomCollectionsListPage> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
}

