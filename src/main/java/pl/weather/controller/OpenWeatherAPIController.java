package pl.weather.controller;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import pl.weather.model.Location;
import pl.weather.model.OpenWeatherAPIConnector;
import pl.weather.model.WeatherData;
import pl.weather.model.auxiliaryMethods.StringMethods;
import pl.weather.model.config.ConfigAPIOpenWeather;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public class OpenWeatherAPIController {

    Gson gson = new Gson();

    private String cityInput;
    private String weatherLocation;

    public OpenWeatherAPIController(String cityInput) throws MalformedURLException {
        this.cityInput = cityInput;
    }

    public String getCityInput() {
        return cityInput;
    }

    private String queryLocation = ConfigAPIOpenWeather.CITY_API_MAIN_QUERY
            + getCityInput()
            + ConfigAPIOpenWeather.LOCAL_NAMES
            + ConfigAPIOpenWeather.LIMIT_OF_LOCATIONS
            + ConfigAPIOpenWeather.BEFORE_API_KEY
            + ConfigAPIOpenWeather.API_KEY;


    private String currentWeather = ConfigAPIOpenWeather.OPEN_WEATHER_MAIN_QUERY
            + getInformationAboutCity().getLocationName()
            + ConfigAPIOpenWeather.UNITS_METRIC_PARAMETER
            + ConfigAPIOpenWeather.LANGUAGE_CODE
            + ConfigAPIOpenWeather.BEFORE_API_KEY
            + ConfigAPIOpenWeather.API_KEY;

    private String fiveDaysWeather = ConfigAPIOpenWeather.OPEN_WEATHER_FIVE_DAYS_MAIN_QUERY
            + getInformationAboutCity().getLocationName()
            + ConfigAPIOpenWeather.UNITS_METRIC_PARAMETER
            + ConfigAPIOpenWeather.LANGUAGE_CODE
            + ConfigAPIOpenWeather.BEFORE_API_KEY
            + ConfigAPIOpenWeather.API_KEY;


    public Location getInformationAboutCity() throws MalformedURLException {
        OpenWeatherAPIConnector apiConnectorCity = new OpenWeatherAPIConnector();
        JSONObject jsonData = (JSONObject) (apiConnectorCity.getJSONArray(queryLocation)).get(0);
        String locationName = jsonData.get("name").toString();
        String countryName = jsonData.get("country").toString();
        double longitude = (double) jsonData.get("lon");
        double latitude = (double) jsonData.get("lat");
        Location location = new Location(locationName, countryName, longitude, latitude);

        return location;
    }

    public WeatherData getCurrentWeather() throws IOException {
        String json = StringMethods.readUrlAPI(currentWeather);
        return gson.fromJson(json, WeatherData.class);

    }

    public JSONObject getCurrentWeatherInformation() throws MalformedURLException {
        OpenWeatherAPIConnector apiConnectorWeather = new OpenWeatherAPIConnector();
        JSONObject currentWeatherJSONObject = (JSONObject) apiConnectorWeather.getJSONObject(currentWeather).get("r");

        return currentWeatherJSONObject;
    }





}

