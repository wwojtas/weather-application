package pl.weather.controller.service;

import pl.weather.model.weather.WeatherForApp;

import java.util.ArrayList;

public class OpenWeatherAPIServiceStub implements OpenWeatherDataRepository {

    @Override
    public WeatherForApp getWeatherData() {
        ArrayList<String> nextDayIconIdCode = new ArrayList<>();
        nextDayIconIdCode.add("04d");
        ArrayList<String> nightTemperatureNextDay = new ArrayList<>();
        nightTemperatureNextDay.add("20");
        ArrayList<String> dailyTemperatureNextDay = new ArrayList<>();
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
