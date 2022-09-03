package pl.weather.model;

import java.net.MalformedURLException;

public interface ConnectionToWeatherData {

    String getResponseFromQueryToAPI(String queryToAPI) throws MalformedURLException;
}
