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

    private final String cityAPI = "https://www.metaweather.com/api/location/search/?query=London";
    private final String weatherAPI = "https://www.metaweather.com/api/location/";

    public void getWeatherData() throws MalformedURLException {
        JSONObject todaysWeather = getCurrentWeatherInformation(getWoeid());
        weatherText.setText(
                "Min temperature: " + todaysWeather.get("min_temp") +
                        "\nCurrent temperature: " + todaysWeather.get("the_temp") +
                        "\nMax temperature: " + todaysWeather.get("max_temp")
        );
    }

    public String getWoeid() throws MalformedURLException {
        OpenWeatherAPIConnector apiConnectorCity = new OpenWeatherAPIConnector(cityAPI);
        JSONObject jsonData = (JSONObject) (apiConnectorCity.getJSONArray(cityInput.getText())).get(0);

        return jsonData.get("woeid").toString();
    }

    public JSONObject getCurrentWeatherInformation(String woeid) throws MalformedURLException {

        OpenWeatherAPIConnector apiConnectorWeather = new OpenWeatherAPIConnector(weatherAPI);
        JSONObject weatherJSONObject = apiConnectorWeather.getJSONObject(woeid + "/");
        JSONArray weatherArray = (JSONArray) weatherJSONObject.get("consolidated_weather");

        return  (JSONObject) weatherArray.get(0);
    }

}

