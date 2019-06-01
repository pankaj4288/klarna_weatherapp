package com.pankaj.weather.model;

import android.Manifest;
import android.arch.lifecycle.MutableLiveData;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.pankaj.weather.network.APIClient;
import com.pankaj.weather.network.APIInterface;
import com.pankaj.weather.view.WeatherActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherInfo {

    private FusedLocationProviderClient mFusedLocationClient;
    public MutableLiveData<WeatherPojo> mWeatherInfo = new MutableLiveData<WeatherPojo>();
    private APIInterface apiInterface;

    public void getWeatherInfo(WeatherActivity activity) {
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(activity);
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        mFusedLocationClient.getLastLocation().addOnSuccessListener(activity, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {

                 if(location!=null){
                     apiInterface = APIClient.getClient().create(APIInterface.class);

                     Call<WeatherPojo> call = apiInterface.getWeatherInfo(location.getLatitude()+","+location.getLongitude());
                     call.enqueue(new Callback<WeatherPojo>() {
                         @Override
                         public void onResponse(Call<WeatherPojo> call, Response<WeatherPojo> response) {
                             mWeatherInfo.setValue((WeatherPojo)response.body());
                         }

                         @Override
                         public void onFailure(Call<WeatherPojo> call, Throwable t) {

                         }
                     });
                 }
            }
        });

    }

}
