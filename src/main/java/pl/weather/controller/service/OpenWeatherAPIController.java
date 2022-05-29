package pl.weather.controller.service;

import com.google.gson.Gson;
import javafx.scene.image.Image;
import pl.weather.model.ConnectionToOpenWeather;
import pl.weather.model.config.ConfigAPIOpenWeather;
import pl.weather.model.config.ConfigApiKey;
import pl.weather.model.weather.WeatherOneCall;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenWeatherAPIController  {

    Gson gson = new Gson();

    private final String latitude;
    private final String longitude;

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

    private WeatherOneCall getWeatherOneCall() throws MalformedURLException {
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
        String response = new ConnectionToOpenWeather().getResponseFromQueryToAPI(queryWeather);
        WeatherOneCall weatherOneCall = gson.fromJson(response, WeatherOneCall.class);
        return weatherOneCall;
    }

    public String getTimezone() throws MalformedURLException {
        String timezone = getWeatherOneCall().getTimezone();
        return timezone;
    }

    public String getCurrentTemperature() throws MalformedURLException {
        String temp = String.format("%.0f", getWeatherOneCall().getCurrent().getTemp());
        return temp;
    }

    public String getCurrentPressure() throws MalformedURLException {
        String pressure = String.format("%.0f", getWeatherOneCall().getCurrent().getPressure());
        return pressure;
    }

    public String getCurrentHumidity() throws MalformedURLException {
        String humidity = String.format("%.0f", getWeatherOneCall().getCurrent().getHumidity());
        return humidity;
    }

    private String getQueryToApiIcons(String imageIdCode) {
        String queryToApi = ConfigAPIOpenWeather.OPEN_WEATHER_ICON_CALL
                + imageIdCode
                + ConfigAPIOpenWeather.ICON_CALL_LAST_PARAMETER;
        return queryToApi;
    }

    private Image getImage(String imageIdCode) throws MalformedURLException {
        String queryToApi = getQueryToApiIcons(imageIdCode);
        URL url = new URL(queryToApi);
        return new Image(String.valueOf(url));
    }

    public Image getCurrentDayIcon() throws MalformedURLException {
        String imageIdCode = getWeatherOneCall().getCurrent().getWeather().get(0).getIcon();
        return getImage(imageIdCode);
    }

    public Image getNextDayIcon(int numberOfDay) throws MalformedURLException {
        String imageIdCode = getWeatherOneCall().getDaily().get(numberOfDay).getWeather().get(0).getIcon();
        return getImage(imageIdCode);
    }

    public String getNightTemperatureNextDay(int numberOfDay) throws MalformedURLException {
        String temp = String.format( "%.0f", getWeatherOneCall().getDaily().get(numberOfDay).getTemp().getNight() );
        return temp;
    }

    public String getDailyTemperatureNextDay(int numberOfDay) throws MalformedURLException {
        String temp = String.format("%.0f", getWeatherOneCall().getDaily().get(numberOfDay).getTemp().getDay());
        return temp;
    }


}

