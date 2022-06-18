package pl.weather.controller.service;

import pl.weather.model.ConnectionToOpenWeather;
import pl.weather.model.config.ConfigAPIOpenWeather;
import pl.weather.model.config.ConfigApiKey;
import pl.weather.model.config.ConfigMainSettings;
import pl.weather.model.weather.WeatherForApp;
import pl.weather.model.weather.WeatherOneCall;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class OpenWeatherAPIService {

    private final String latitude;
    private final String longitude;

    public OpenWeatherAPIService(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public WeatherForApp getWeatherForAppObject() throws MalformedURLException {
        String queryWeather = ConfigAPIOpenWeather.OPEN_WEATHER_ONE_CALL_MAIN_QUERY
                + ConfigAPIOpenWeather.LATITUDE_PREFIX
                + getLatitude()
                + ConfigAPIOpenWeather.LONGITUDE_PREFIX
                + getLongitude()
                + ConfigAPIOpenWeather.EXCLUDE_PARAMETERS
                + ConfigAPIOpenWeather.UNITS_PARAMETER
                + ConfigAPIOpenWeather.LANGUAGE_CODE
                + ConfigAPIOpenWeather.BEFORE_API_KEY
                + ConfigApiKey.OPEN_WEATHER_API_KEY;
        String response = new ConnectionToOpenWeather().getResponseFromQueryToAPI(queryWeather);
        WeatherOneCall weatherOneCallGsonObject = ConfigMainSettings.createGsonStaticObject().fromJson(response, WeatherOneCall.class);
        String timezone = weatherOneCallGsonObject.getTimezone();
        String currentTemperature = String.format("%.0f", weatherOneCallGsonObject.getCurrent().getTemp());
        String currentPressure = String.format("%.0f", weatherOneCallGsonObject.getCurrent().getPressure());
        String currentHumidity = String.format("%.0f", weatherOneCallGsonObject.getCurrent().getHumidity());
        String currentDayIconIdCode = weatherOneCallGsonObject.getCurrent().getWeather().get(0).getIcon();
        ArrayList<String> nextDayIconIdCode = new ArrayList<>();
        for (int i = 0; i <= ConfigAPIOpenWeather.NUMBER_OF_DAYS; i++) {
            nextDayIconIdCode.add(weatherOneCallGsonObject.getDaily().get(i).getWeather().get(0).getIcon());
        }
        ArrayList<String> nightTemperatureNextDay = new ArrayList<>();
        for (int i = 0; i <= ConfigAPIOpenWeather.NUMBER_OF_DAYS; i++) {
            nightTemperatureNextDay.add(String.format( "%.0f", weatherOneCallGsonObject.getDaily().get(i).getTemp().getNight()));
        }
        ArrayList<String> dailyTemperatureNextDay = new ArrayList<>();
        for (int i = 0; i <= ConfigAPIOpenWeather.NUMBER_OF_DAYS; i++) {
            dailyTemperatureNextDay.add(String.format("%.0f", weatherOneCallGsonObject.getDaily().get(i).getTemp().getDay()));
        }
        return new WeatherForApp(timezone,
                currentTemperature,
                currentPressure,
                currentHumidity,
                currentDayIconIdCode,
                nextDayIconIdCode,
                nightTemperatureNextDay,
                dailyTemperatureNextDay);
    }


}

