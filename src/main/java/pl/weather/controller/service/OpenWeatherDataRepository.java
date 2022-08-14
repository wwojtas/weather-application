package pl.weather.controller.service;

import pl.weather.model.weather.WeatherForApp;

import java.net.MalformedURLException;

public interface OpenWeatherDataRepository {

    WeatherForApp getWeatherData() throws MalformedURLException;
}
