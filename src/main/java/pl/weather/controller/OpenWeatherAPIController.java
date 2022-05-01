package pl.weather.controller;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import pl.weather.model.*;
import pl.weather.model.config.ConfigAPIOpenWeather;

import java.net.MalformedURLException;

public class OpenWeatherAPIController  {


    private String cityInput;
    private String latitude;
    private String longitude;

//    public OpenWeatherAPIController(String cityInput) throws MalformedURLException {
//        this.cityInput = cityInput;
//    }

//    public OpenWeatherAPIController(String latitude, String longitude) {
//        this.latitude = latitude;
//        this.longitude = longitude;
//    }

    public String getCityInput() {
        return cityInput;
    }

    private final String queryLocation = ConfigAPIOpenWeather.CITY_API_MAIN_QUERY
            + getCityInput()
            + ConfigAPIOpenWeather.LOCAL_NAMES
            + ConfigAPIOpenWeather.LIMIT_OF_LOCATIONS
            + ConfigAPIOpenWeather.BEFORE_API_KEY
            + ConfigAPIOpenWeather.API_KEY;



    public Location getInformationAboutLocation() throws MalformedURLException {
        Connector apiConnectorCity = new Connector();
        JSONObject jsonData = (JSONObject) (apiConnectorCity.getJSONArray(queryLocation)).get(0);
        String locationName = jsonData.get("name").toString();
        String countryName = jsonData.get("country").toString();
        double longitude = (double) jsonData.get("lon");
        double latitude = (double) jsonData.get("lat");
        Location location = new Location(locationName, countryName, longitude, latitude);

        return location;
    }

    public String getStringResponseToQueryWeather(String latitude, String longitude){
        Gson gson = new Gson();
        String queryWeather = ConfigAPIOpenWeather.OPEN_WEATHER_ONE_CALL_MAIN_QUERY
                + ConfigAPIOpenWeather.LATITUDE_PREFIX
                + latitude
                + ConfigAPIOpenWeather.LONGITUDE_PREFIX
                + longitude
                + ConfigAPIOpenWeather.EXCLUDE_PARAMETERS
                + ConfigAPIOpenWeather.UNITS_PARAMETER
                + ConfigAPIOpenWeather.LANGUAGE_CODE
                + ConfigAPIOpenWeather.BEFORE_API_KEY
                + ConfigAPIOpenWeather.API_KEY;
        String downloadedJSON = new Connector().getResponseFromQueryToAPI(queryWeather);
        return downloadedJSON;
    }






}

