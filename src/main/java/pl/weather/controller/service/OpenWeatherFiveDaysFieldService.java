package pl.weather.controller.service;

import javafx.scene.image.Image;
import pl.weather.model.config.ConfigAPIOpenWeather;
import pl.weather.model.weather.WeatherForApp;

public class OpenWeatherFiveDaysFieldService {

    public Image getCurrentDayIcon(WeatherForApp weatherForApp)  {
        return ConfigAPIOpenWeather.getWeatherImage(weatherForApp.getCurrentDayIconIdCode());
    }

    public Image getNextDayIcon(WeatherForApp weatherForApp, int numberOfDay)  {
        return ConfigAPIOpenWeather.getWeatherImage(weatherForApp.getNextDayIconIdCode().get(numberOfDay));
    }

    public String getDailyTemperatureNextDay(WeatherForApp weatherForApp, int numberOfDay)  {
        return weatherForApp.getDailyTemperatureNextDay().get(numberOfDay);
    }

    public String getNightTemperatureNextDay(WeatherForApp weatherForApp, int numberOfDay) {
        return weatherForApp.getNightTemperatureNextDay().get(numberOfDay);
    }

}
