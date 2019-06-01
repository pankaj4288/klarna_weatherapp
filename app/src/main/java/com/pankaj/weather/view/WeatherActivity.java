package com.pankaj.weather.view;

import android.Manifest;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.pankaj.weather.R;
import com.pankaj.weather.databinding.WeatherActivityBinding;
import com.pankaj.weather.model.WeatherPojo;
import com.pankaj.weather.viewmodel.WeatherViewModel;

public class WeatherActivity extends AppCompatActivity implements PermissionListener {

    private WeatherViewModel mWeatherViewModel;
    private TextView mWeatherInfoTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        mWeatherInfoTv = findViewById(R.id.weather_info);
    }

    private void initDataBinding() {

        WeatherActivityBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_weather);
        mWeatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
        mWeatherViewModel.init(this);
        binding.setWeatherViewModel(mWeatherViewModel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            Dexter.withActivity(this).withPermission(Manifest.permission.ACCESS_COARSE_LOCATION).withListener(this).check();
        } else {
            mWeatherViewModel.getWeatherInfo().observe(this,this::weatherUpdated);
        }
    }

    private void weatherUpdated(WeatherPojo weatherPojo){
        StringBuilder output = new StringBuilder();
        output.append(getString(R.string.latitude)+" "+weatherPojo.getLatitude()+"\n");
        output.append(getString(R.string.longitude)+" "+weatherPojo.getLongitude()+"\n");
        output.append(getString(R.string.timezone)+" "+weatherPojo.getTimezone()+"\n");
        output.append(getString(R.string.time)+" "+weatherPojo.getCurrently().getTime()+"\n");
        output.append(getString(R.string.summary)+" "+weatherPojo.getCurrently().getSummary()+"\n");
        output.append(getString(R.string.icon)+" "+weatherPojo.getCurrently().getIcon()+"\n");
        output.append(getString(R.string.precip_intensity)+" "+weatherPojo.getCurrently().getPrecipIntensity()+"\n");
        output.append(getString(R.string.precip_probability)+" "+weatherPojo.getCurrently().getPrecipProbability()+"\n");
        output.append(getString(R.string.temperature)+" "+weatherPojo.getCurrently().getTemperature()+"\n");
        output.append(getString(R.string.apparent_temperature)+" "+weatherPojo.getCurrently().getApparentTemperature()+"\n");
        output.append(getString(R.string.dew_point)+" "+weatherPojo.getCurrently().getDewPoint()+"\n");
        output.append(getString(R.string.humidity)+" "+weatherPojo.getCurrently().getHumidity()+"\n");
        output.append(getString(R.string.pressure)+" "+weatherPojo.getCurrently().getPressure()+"\n");
        output.append(getString(R.string.wind_speed)+" "+weatherPojo.getCurrently().getWindSpeed()+"\n");
        output.append(getString(R.string.wind_gust)+" "+weatherPojo.getCurrently().getWindGust()+"\n");
        output.append(getString(R.string.wind_bearing)+" "+weatherPojo.getCurrently().getWindBearing()+"\n");
        output.append(getString(R.string.cloud_cover)+" "+weatherPojo.getCurrently().getCloudCover()+"\n");
        output.append(getString(R.string.uv_ndex)+" "+weatherPojo.getCurrently().getUvIndex()+"\n");
        output.append(getString(R.string.visibility)+" "+weatherPojo.getCurrently().getVisibility()+"\n");
        output.append(getString(R.string.ozone)+" "+weatherPojo.getCurrently().getOzone());
        mWeatherInfoTv.setText(output.toString());
    }

    @Override
    public void onPermissionGranted(PermissionGrantedResponse response) {
        mWeatherViewModel.getWeatherInfo().observe(this,this::weatherUpdated);

    }

    @Override
    public void onPermissionDenied(PermissionDeniedResponse response) {

    }

    @Override
    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

    }

}
