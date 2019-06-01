package com.pankaj.weather.model;

import com.google.gson.annotations.SerializedName;

public class WeatherPojo {

    @SerializedName("latitude")
    private double latitude;

    @SerializedName("longitude")
    private double longitude;

    @SerializedName("timezone")
    private String timezone;

    private Currently currently;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Currently getCurrently() {
        return currently;
    }

    public void setCurrently(Currently currently) {
        this.currently = currently;
    }

    public class Currently{

        @SerializedName("time")
        private long time;

        @SerializedName("summary")
        private String summary;

        @SerializedName("icon")
        private String icon;

        @SerializedName("precipIntensity")
        private int precipIntensity;

        @SerializedName("precipProbability")
        private int precipProbability;

        @SerializedName("temperature")
        private double temperature;

        @SerializedName("apparentTemperature")
        private double apparentTemperature;

        @SerializedName("dewPoint")
        private double dewPoint;

        @SerializedName("humidity")
        private double humidity;

        @SerializedName("pressure")
        private double pressure;

        @SerializedName("windSpeed")
        private double windSpeed;

        @SerializedName("windGust")
        private double windGust;

        @SerializedName("windBearing")
        private int windBearing;

        @SerializedName("cloudCover")
        private double cloudCover;

        @SerializedName("uvIndex")
        private int uvIndex;

        @SerializedName("visibility")
        private double visibility;

        @SerializedName("ozone")
        private double ozone;

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getPrecipIntensity() {
            return precipIntensity;
        }

        public void setPrecipIntensity(int precipIntensity) {
            this.precipIntensity = precipIntensity;
        }

        public int getPrecipProbability() {
            return precipProbability;
        }

        public void setPrecipProbability(int precipProbability) {
            this.precipProbability = precipProbability;
        }

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public double getApparentTemperature() {
            return apparentTemperature;
        }

        public void setApparentTemperature(double apparentTemperature) {
            this.apparentTemperature = apparentTemperature;
        }

        public double getDewPoint() {
            return dewPoint;
        }

        public void setDewPoint(double dewPoint) {
            this.dewPoint = dewPoint;
        }

        public double getHumidity() {
            return humidity;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        public double getPressure() {
            return pressure;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }

        public double getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
        }

        public double getWindGust() {
            return windGust;
        }

        public void setWindGust(double windGust) {
            this.windGust = windGust;
        }

        public int getWindBearing() {
            return windBearing;
        }

        public void setWindBearing(int windBearing) {
            this.windBearing = windBearing;
        }

        public double getCloudCover() {
            return cloudCover;
        }

        public void setCloudCover(double cloudCover) {
            this.cloudCover = cloudCover;
        }

        public int getUvIndex() {
            return uvIndex;
        }

        public void setUvIndex(int uvIndex) {
            this.uvIndex = uvIndex;
        }

        public double getVisibility() {
            return visibility;
        }

        public void setVisibility(double visibility) {
            this.visibility = visibility;
        }

        public double getOzone() {
            return ozone;
        }

        public void setOzone(double ozone) {
            this.ozone = ozone;
        }
    }
}
