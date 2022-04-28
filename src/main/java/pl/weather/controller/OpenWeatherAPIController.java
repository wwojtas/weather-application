package pl.weather.controller;

import org.json.simple.JSONObject;
import pl.weather.model.Location;
import pl.weather.model.Connector;
import pl.weather.model.config.ConfigAPIOpenWeather;

import java.net.MalformedURLException;

public class OpenWeatherAPIController {

    private String cityInput;

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

    private String queryWeather = ConfigAPIOpenWeather.QUERY_WEATHER;

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

    public String getStringResponseToQueryWeather(){
        String pobranyJson = new Connector().getResponseFromQueryToAPI(queryWeather);
        return pobranyJson;
    }








}

