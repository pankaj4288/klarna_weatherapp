package com.pankaj.weather.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static Retrofit getClient() {

        return new Retrofit.Builder()
                .baseUrl("https://api.darksky.net/forecast/2bb07c3bece89caf533ac9a5d23d8417/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

    }
}
