package pl.weather.controller;

import com.google.gson.Gson;
import javafx.scene.image.Image;
import org.json.simple.JSONObject;
import pl.weather.model.*;
import pl.weather.model.config.ConfigAPIOpenWeather;
import pl.weather.model.config.ConfigMainSettings;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenWeatherAPIController  {

    Gson gson = new Gson();

    private String cityInput;
    private String latitude;
    private String longitude;


    public OpenWeatherAPIController(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCityInput() {
        return cityInput;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    private final String queryLocation = ConfigAPIOpenWeather.CITY_API_MAIN_QUERY
            + getCityInput()
            + ConfigAPIOpenWeather.LOCAL_NAMES
            + ConfigAPIOpenWeather.LIMIT_OF_LOCATIONS
            + ConfigAPIOpenWeather.BEFORE_API_KEY
            + ConfigAPIOpenWeather.API_KEY;

    private Location getInformationAboutLocation() throws MalformedURLException {
        Connector apiConnectorCity = new Connector();
        JSONObject jsonData = (JSONObject) (apiConnectorCity.getJSONArray(queryLocation)).get(0);
        String locationName = jsonData.get("name").toString();
        String countryName = jsonData.get("country").toString();
        double longitude = (double) jsonData.get("lon");
        double latitude = (double) jsonData.get("lat");
        Location location = new Location(locationName, countryName, longitude, latitude);

        return location;
    }

    private String getStringResponseToQueryWeather(){
        String queryWeather = ConfigAPIOpenWeather.OPEN_WEATHER_ONE_CALL_MAIN_QUERY
                + ConfigAPIOpenWeather.LATITUDE_PREFIX
                + getLatitude()
                + ConfigAPIOpenWeather.LONGITUDE_PREFIX
                + getLongitude()
                + ConfigAPIOpenWeather.EXCLUDE_PARAMETERS
                + ConfigAPIOpenWeather.UNITS_PARAMETER
                + ConfigAPIOpenWeather.LANGUAGE_CODE
                + ConfigAPIOpenWeather.BEFORE_API_KEY
                + ConfigAPIOpenWeather.API_KEY;
        String downloadedJSON = new Connector().getResponseFromQueryToAPI(queryWeather);
        return downloadedJSON;
    }

    private WeatherOneCall getWeatherOneCall(){
        String response = getStringResponseToQueryWeather();
        WeatherOneCall weatherOneCall = gson.fromJson(response, WeatherOneCall.class);
        return weatherOneCall;
    }

    public String getCurrentTemperature(){
        String temp = String.format("%.0f", getWeatherOneCall().getCurrent().getTemp());
        return temp;
    }

    public String getCurrentPressure(){
        String pressure = String.format("%.0f", getWeatherOneCall().getCurrent().getPressure());
        return pressure;
    }

    public String getCurrentHumidity() {
        String humidity = String.format("%.0f", getWeatherOneCall().getCurrent().getHumidity());
        return humidity;
    }

    private String getQueryToApiIcons(String imageIdCode) {
        String queryToApi = ConfigAPIOpenWeather.OPEN_WEATHER_ICON_CALL
                + imageIdCode
                + ConfigAPIOpenWeather.ICON_CALL_LAST_PARAMETER;
        return queryToApi;
    }

    private Image getImage(String imageIdCode) {
        String queryToApi = getQueryToApiIcons(imageIdCode);
        URL url = null;
        try {
            url = new URL(queryToApi);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new Image(String.valueOf(url));
    }

    public Image getCurrentDayIcon() {
        String imageIdCode = getWeatherOneCall().getCurrent().getWeather().get(0).getIcon();
        return getImage(imageIdCode);
    }

    public Image getNextDayIcon(int numberOfDay){
        String imageIdCode = getWeatherOneCall().getDaily().get(numberOfDay).getWeather().get(0).getIcon();
        return getImage(imageIdCode);
    }

    public String getNightTemperatureNextDay(int numberOfDay){
        String temp = String.format( "%.0f", getWeatherOneCall().getDaily().get(numberOfDay).getTemp().getNight() );
        return temp;
    }

    public String getDailyTemperatureNextDay(int numberOfDay){
        String temp = String.format("%.0f", getWeatherOneCall().getDaily().get(numberOfDay).getTemp().getDay());
        return temp;
    }






}

