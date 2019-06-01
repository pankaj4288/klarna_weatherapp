package com.pankaj.weather.network;

import com.pankaj.weather.model.WeatherPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {

    @GET("{latlong}")
    Call<WeatherPojo> getWeatherInfo(@Path("latlong") String latlong);
}
