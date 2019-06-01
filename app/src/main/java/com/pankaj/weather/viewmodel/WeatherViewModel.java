package com.pankaj.weather.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.pankaj.weather.model.WeatherInfo;
import com.pankaj.weather.model.WeatherPojo;
import com.pankaj.weather.view.WeatherActivity;

public class WeatherViewModel extends ViewModel {

    private WeatherInfo mWeatherInfo;

    public void init(WeatherActivity activity){
        mWeatherInfo = new WeatherInfo();
        mWeatherInfo.getWeatherInfo(activity);
    }

    public MutableLiveData<WeatherPojo> getWeatherInfo(){
        return mWeatherInfo.mWeatherInfo;
    }
}