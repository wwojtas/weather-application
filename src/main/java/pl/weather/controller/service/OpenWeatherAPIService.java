package pl.weather.controller.service;

import javafx.scene.image.Image;
import pl.weather.model.ConnectionToOpenWeather;
import pl.weather.model.config.ConfigAPIOpenWeather;
import pl.weather.model.config.ConfigApiKey;
import pl.weather.model.config.ConfigMainSettings;
import pl.weather.model.weather.WeatherOneCall;

import java.net.MalformedURLException;
import java.net.URL;
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
        WeatherOneCall weatherOneCallGsonObject = ConfigMainSettings.createGsonStaticObject().fromJson(response, WeatherOneCall.class);
        String timezone = weatherOneCallGsonObject.getTimezone();
        String currentTemperature = String.format("%.0f", weatherOneCallGsonObject.getCurrent().getTemp());
        String currentPressure = String.format("%.0f", weatherOneCallGsonObject.getCurrent().getPressure());
        String currentHumidity = String.format("%.0f", weatherOneCallGsonObject.getCurrent().getHumidity());
        String currentDayIconIdCode = weatherOneCallGsonObject.getCurrent().getWeather().get(0).getIcon();
        ArrayList<String> nextDayIconIdCode = new ArrayList<>();
        for (int i = 0; i <= ConfigAPIOpenWeather.NUMBER_OF_DAYS; i++) {
            nextDayIconIdCode.add(i, weatherOneCallGsonObject.getDaily().get(i).getWeather().get(0).getIcon());
        }
        ArrayList<String> nightTemperatureNextDay = new ArrayList<>();
        for (int i = 0; i < ConfigAPIOpenWeather.NUMBER_OF_DAYS; i++) {
            nightTemperatureNextDay.add(i, String.format( "%.0f", getWeatherOneCall().getDaily().get(i).getTemp().getNight()));
        }

        ArrayList<String> dailyTemperatureNextDay = new ArrayList<>();
        for (int i = 0; i < ConfigAPIOpenWeather.NUMBER_OF_DAYS; i++) {
            dailyTemperatureNextDay.add(i, String.format("%.0f", getWeatherOneCall().getDaily().get(i).getTemp().getDay()));
        }

    }


    private Image getImage(String imageIdCode) throws MalformedURLException {

        String queryToApi = ConfigAPIOpenWeather.OPEN_WEATHER_ICON_CALL
                + imageIdCode
                + ConfigAPIOpenWeather.ICON_CALL_LAST_PARAMETER;
        return new Image(queryToApi);
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
        return String.format( "%.0f", getWeatherOneCall().getDaily().get(numberOfDay).getTemp().getNight() );
    }

    public String getDailyTemperatureNextDay(int numberOfDay) throws MalformedURLException {
        return String.format("%.0f", getWeatherOneCall().getDaily().get(numberOfDay).getTemp().getDay());
    }


//    public String getTimezone() throws MalformedURLException {
//        String timezone = getWeatherOneCall().getTimezone();
//        return timezone;
//    }
//
//    public String getCurrentTemperature() throws MalformedURLException {
//        return String.format("%.0f", getWeatherOneCall().getCurrent().getTemp());
//    }
//
//    public String getCurrentPressure() throws MalformedURLException {
//        return String.format("%.0f", getWeatherOneCall().getCurrent().getPressure());
//    }
//
//    public String getCurrentHumidity() throws MalformedURLException {
//        return String.format("%.0f", getWeatherOneCall().getCurrent().getHumidity());
//    }

//    private String getQueryToApiIcons(String imageIdCode) {
//        return ConfigAPIOpenWeather.OPEN_WEATHER_ICON_CALL
//                + imageIdCode
//                + ConfigAPIOpenWeather.ICON_CALL_LAST_PARAMETER;
//    }


}

