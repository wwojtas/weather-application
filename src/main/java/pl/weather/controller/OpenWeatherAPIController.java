package pl.weather.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pl.weather.model.OpenWeatherAPIConnector;

import java.net.MalformedURLException;

public class OpenWeatherAPIController {

    private TextField cityInput;
    private Text weatherText;

//    private final String cityAPI = "https://www.metaweather.com/api/location/search/?query=London";
//    private final String weatherAPI = "https://www.metaweather.com/api/location/";

    private final String cityAPI = "http://api.openweathermap.org/geo/1.0/direct?q={city name}&local_names.[pl]&limit=3&appid={API key}";
    private final String cityAPI = "http://api.openweathermap.org/geo/1.0/direct?q=";
    private final String PREFIX_LOCAL_NAMES = "&local_names.[pl]";
    private final String PREFIX_LIMIT_OF_LOCATIONS = "&limit=3";
    private final String PREFIX_BEFORE_API_KEY = "&appid=";
    private final String API_KEY = "";

    private final String weatherAPI = "https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}&units=metric";
    private final String weatherAPI = "https://api.openweathermap.org/data/2.5/weather?q=";
    private final String PREFIX_UNITS = "&units=metric";






    public void getWeatherData() throws MalformedURLException {
        JSONObject todaysWeather = getCurrentWeatherInformation(getCityName());
        weatherText.setText(
                "Min temperature: " + todaysWeather.get("min_temp") +
                        "\nCurrent temperature: " + todaysWeather.get("the_temp") +
                        "\nMax temperature: " + todaysWeather.get("max_temp")
        );
    }

    public String getCityName() throws MalformedURLException {

        OpenWeatherAPIConnector apiConnectorCity = new OpenWeatherAPIConnector(cityAPI);

        JSONObject jsonData = (JSONObject) (apiConnectorCity.getJSONArray(cityInput.getText())).get(0);

        return jsonData.get("name").toString();
    }

    public JSONObject getCurrentWeatherInformation(String cityName) throws MalformedURLException {

        OpenWeatherAPIConnector apiConnectorWeather = new OpenWeatherAPIConnector(weatherAPI);
        JSONObject currentWeatherJSONObject = apiConnectorWeather.getJSONObject(cityName + "/");
        JSONArray weatherArray = (JSONArray) currentWeatherJSONObject.get("consolidated_weather");

        return (JSONObject) weatherArray.get(0);
    }

//    =======================================================

    public JSONObject getFiveDaysWeatherInformation(String woeid) throws MalformedURLException {
        OpenWeatherAPIConnector apiConnectorWeather = new OpenWeatherAPIConnector(weatherAPI);
        JSONObject fiveDaysWeatherJSONObject = apiConnectorWeather.getJSONObject(woeid + "/");
        JSONArray weatherArray = (JSONArray) fiveDaysWeatherJSONObject.get("consolidated_weather");

        return (JSONObject) weatherArray.get(0);

    }

}

