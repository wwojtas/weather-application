package pl.weather.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pl.weather.model.auxiliaryMethods.JSONUseful;
import pl.weather.model.auxiliaryMethods.StringMethods;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenWeatherAPIConnector {

    private final String urlString;

    public OpenWeatherAPIConnector(String urlString) throws MalformedURLException {
        this.urlString = urlString;
    }

    public JSONArray getJSONArray(String query) {
        try {
            URL urlToOpenWeatherMap = new URL(urlString + query);
            InternetConnection.isHttpURLConnection(urlToOpenWeatherMap);
            StringBuilder informationString = StringMethods.readAndCloseStringBuilder(urlToOpenWeatherMap);
            return JSONUseful.parseStringBuilderToJSONArray(informationString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject getJSONObject(String query) {
        try {
            URL urlToOpenWeatherMap = new URL(urlString + query);
            InternetConnection.isHttpURLConnection(urlToOpenWeatherMap);
            StringBuilder informationString = StringMethods.readAndCloseStringBuilder(urlToOpenWeatherMap);
            return JSONUseful.parseStringBuilderToJSONObject(informationString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


