package pl.weather.controller.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import pl.weather.model.ConnectionToOpenWeather;
import pl.weather.model.config.ConfigAPIOpenWeather;
import pl.weather.model.config.ConfigApiKey;
import pl.weather.model.geocoding.Geocoding;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class OpenWeatherGeocodingAPIController {

    Gson gson = new Gson();

    private final String cityInput;

    public OpenWeatherGeocodingAPIController(String cityInput) {
        this.cityInput = cityInput;
    }

    public String getCityInput() {
        return cityInput;
    }

    private ArrayList<Geocoding> getGeocodingFromOpenWeather() throws MalformedURLException {
        String queryLocation = ConfigAPIOpenWeather.CITY_API_MAIN_QUERY
                + getCityInput()
                + ConfigAPIOpenWeather.LOCAL_NAMES
                + ConfigAPIOpenWeather.LIMIT_OF_LOCATIONS
                + ConfigAPIOpenWeather.BEFORE_API_KEY
                + ConfigApiKey.OW_API_KEY;
        String response = new ConnectionToOpenWeather().getResponseFromQueryToAPI(queryLocation);
        Type collectionType = new TypeToken<ArrayList<Geocoding>>(){}.getType();
        ArrayList<Geocoding> geocoding = gson.fromJson(response, collectionType);
        return geocoding;
    }

    public String getLongitude() throws MalformedURLException {
        String longitude = String.format("%.8f", getGeocodingFromOpenWeather().get(0).getLon());
        return longitude;
    }
    public String getLatitude() throws MalformedURLException {
        String latitude = String.format("%.8f", getGeocodingFromOpenWeather().get(0).getLat());
        return latitude;
    }

    public String getCity() throws MalformedURLException {
        String country = getGeocodingFromOpenWeather().get(0).getLocalNames().getPl();
        return country;
    }

    public String getCountry() throws MalformedURLException {
        String city = getGeocodingFromOpenWeather().get(0).getCountry();
        return city;
    }







}
