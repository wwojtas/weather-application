package pl.weather.controller;

import com.google.gson.Gson;
import javafx.scene.image.Image;
import pl.weather.model.Connector;
import pl.weather.model.config.ConfigAPIOpenWeather;
import pl.weather.model.config.ConfigApiKey;
import pl.weather.model.weather.WeatherOneCall;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenWeatherAPIController  {

    Gson gson = new Gson();

    private String latitude;
    private String longitude;

    public OpenWeatherAPIController(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    private WeatherOneCall getWeatherOneCall(){
        String queryWeather = ConfigAPIOpenWeather.OPEN_WEATHER_ONE_CALL_MAIN_QUERY
                + ConfigAPIOpenWeather.LATITUDE_PREFIX
                + getLatitude()
                + ConfigAPIOpenWeather.LONGITUDE_PREFIX
                + getLongitude()
                + ConfigAPIOpenWeather.EXCLUDE_PARAMETERS
                + ConfigAPIOpenWeather.UNITS_PARAMETER
                + ConfigAPIOpenWeather.LANGUAGE_CODE
                + ConfigAPIOpenWeather.BEFORE_API_KEY
                + ConfigApiKey.OW_API_KEY;
        String response = new Connector().getResponseFromQueryToAPI(queryWeather);
        WeatherOneCall weatherOneCall = gson.fromJson(response, WeatherOneCall.class);
        return weatherOneCall;
    }

    public String getTimezone(){
        String timezone = getWeatherOneCall().getTimezone();
        return timezone;
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

