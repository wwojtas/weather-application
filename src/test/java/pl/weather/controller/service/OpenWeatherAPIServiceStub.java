package pl.weather.controller.service;

import pl.weather.model.weather.WeatherForApp;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class OpenWeatherAPIServiceStub implements OpenWeatherDataRepository {

    @Override
    public WeatherForApp getWeatherData() throws MalformedURLException {
        ArrayList<String> nextDayIconIdCode = new ArrayList<String>();
        nextDayIconIdCode.add("04d");
        ArrayList<String> nightTemperatureNextDay = new ArrayList<String>();
        nightTemperatureNextDay.add("20");
        ArrayList<String> dailyTemperatureNextDay = new ArrayList<String>();
        dailyTemperatureNextDay.add("30");
        return new WeatherForApp("Europe/Warsaw",
                "15",
                "1012",
                "50",
                "10d",
                nextDayIconIdCode,
                nightTemperatureNextDay,
                dailyTemperatureNextDay
        );
    }
}
