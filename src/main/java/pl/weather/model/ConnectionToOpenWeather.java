package pl.weather.model;

import java.net.MalformedURLException;

public interface ConnectionToOpenWeather {

    String getResponseFromQueryToAPI(String queryToAPI) throws MalformedURLException;
}
