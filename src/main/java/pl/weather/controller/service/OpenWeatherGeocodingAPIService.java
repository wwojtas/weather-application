package pl.weather.controller.service;

import com.google.gson.reflect.TypeToken;
import pl.weather.model.ConnectionToOpenWeather;
import pl.weather.model.StandardConnectionToOpenWeather;
import pl.weather.model.GeoIP;
import pl.weather.model.config.ConfigAPIOpenWeather;
import pl.weather.model.config.ConfigApiKey;
import pl.weather.model.config.ConfigMainSettings;
import pl.weather.model.geocoding.Geocoding;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class OpenWeatherGeocodingAPIService {

    private final String cityInput;
    private final ConnectionToOpenWeather connectionToOpenWeather;

    public OpenWeatherGeocodingAPIService(String cityInput, ConnectionToOpenWeather connectionToOpenWeather) {
        this.cityInput = cityInput;
        this.connectionToOpenWeather = connectionToOpenWeather;
    }

    String getCityInput() {
        return cityInput;
    }

    public GeoIP getGeocodingFromOpenWeather() throws MalformedURLException {
        String queryLocation = ConfigAPIOpenWeather.CITY_API_MAIN_QUERY
                + getCityInput()
                + ConfigAPIOpenWeather.LOCAL_NAMES
                + ConfigAPIOpenWeather.LIMIT_OF_LOCATIONS
                + ConfigAPIOpenWeather.BEFORE_API_KEY
                + ConfigApiKey.OPEN_WEATHER_API_KEY;
//        String response = new StandardConnectionToOpenWeather().getResponseFromQueryToAPI(queryLocation);
        String response = connectionToOpenWeather.getResponseFromQueryToAPI(queryLocation);
        Type collectionType = new TypeToken<ArrayList<Geocoding>>(){}.getType();
        ArrayList<Geocoding> geocodingArrayList = ConfigMainSettings.createGsonStaticObject().fromJson(response, collectionType);
        String city = geocodingArrayList.get(0).getLocalNames().getPl();
        String country = geocodingArrayList.get(0).getCountry();
        String latitude = String.format("%.8f", geocodingArrayList.get(0).getLat());
        String longitude = String.format("%.8f", geocodingArrayList.get(0).getLon());

        return new GeoIP(city, country, latitude, longitude);
    }

}
