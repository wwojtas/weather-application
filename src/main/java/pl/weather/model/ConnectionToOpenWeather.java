package pl.weather.model;

import org.json.simple.JSONArray;
import pl.weather.model.auxiliaryMethods.JSONUseful;
import pl.weather.model.auxiliaryMethods.StringMethods;

import java.net.URL;

public class ConnectionToOpenWeather {

    public String getResponseFromQueryToAPI(String queryToAPI) {
        try {
            URL urlConnect = new URL(queryToAPI);
            if( new ConnectionToInternet().isHttpURLConnection(urlConnect)) {
                StringBuilder informationString = StringMethods.readAndCloseStringBuilder(urlConnect);
                return informationString.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public JSONArray getJSONArray(String query) {
//        try {
//            URL urlToOpenWeatherMap = new URL(query);
//            if(ConnectionToInternet.isHttpURLConnection(urlToOpenWeatherMap)){
//                StringBuilder informationString = StringMethods.readAndCloseStringBuilder(urlToOpenWeatherMap);
//                return JSONUseful.parseStringBuilderToJSONArray(informationString);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }



}


