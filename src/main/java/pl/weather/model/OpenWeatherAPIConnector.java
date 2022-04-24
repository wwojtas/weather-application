package pl.weather.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pl.weather.model.auxiliaryMethods.JSONUseful;
import pl.weather.model.auxiliaryMethods.StringMethods;

import java.net.URL;

public class OpenWeatherAPIConnector {

    public JSONArray getJSONArray(String query) {
        try {
            URL urlToOpenWeatherMap = new URL(query);
            if(InternetConnection.isHttpURLConnection(urlToOpenWeatherMap)){
                StringBuilder informationString = StringMethods.readAndCloseStringBuilder(urlToOpenWeatherMap);
                return JSONUseful.parseStringBuilderToJSONArray(informationString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject getJSONObject(String query) {
        try {
            URL urlToOpenWeatherMap = new URL(query);
            if( InternetConnection.isHttpURLConnection(urlToOpenWeatherMap)) {
                StringBuilder informationString = StringMethods.readAndCloseStringBuilder(urlToOpenWeatherMap);
                return JSONUseful.parseStringBuilderToJSONObject(informationString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getJSONFromString(String query) {
        try {
            URL urlToOpenWeatherMap = new URL(query);
            if( InternetConnection.isHttpURLConnection(urlToOpenWeatherMap)) {
                StringBuilder informationString = StringMethods.readAndCloseStringBuilder(urlToOpenWeatherMap);

                return String.valueOf(informationString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}


