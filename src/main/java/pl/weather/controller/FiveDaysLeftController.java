package pl.weather.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import pl.weather.controller.service.OpenWeatherFiveDaysFieldService;
import pl.weather.model.auxiliary.DateAndTimeUtils;
import pl.weather.model.auxiliary.AnotherUtils;
import pl.weather.model.weather.WeatherForApp;

import java.net.MalformedURLException;


public class FiveDaysLeftController {

    @FXML
    Label day1Left;

    @FXML
    Label day2Left;

    @FXML
    Label day3Left;

    @FXML
    Label day4Left;

    @FXML
    Label day5Left;

    @FXML
    ImageView icon1weatherLeft;

    @FXML
    ImageView icon2weatherLeft;

    @FXML
    ImageView icon3weatherLeft;

    @FXML
    ImageView icon4weatherLeft;

    @FXML
    ImageView icon5weatherLeft;

    @FXML
    Label temperature1Left;

    @FXML
    Label temperature2Left;

    @FXML
    Label temperature3Left;

    @FXML
    Label temperature4Left;

    @FXML
    Label temperature5Left;


    public void setFiveDaysData(WeatherForApp weatherForApp) throws MalformedURLException {

        String timeZone = weatherForApp.getTimezone();
        OpenWeatherFiveDaysFieldService fiveDaysFieldService = new OpenWeatherFiveDaysFieldService();

        day1Left.setText(DateAndTimeUtils.getNextDayTextContent(timeZone, 1));
        day2Left.setText(DateAndTimeUtils.getNextDayTextContent(timeZone, 2));
        day3Left.setText(DateAndTimeUtils.getNextDayTextContent(timeZone, 3));
        day4Left.setText(DateAndTimeUtils.getNextDayTextContent(timeZone, 4));
        day5Left.setText(DateAndTimeUtils.getNextDayTextContent(timeZone, 5));

        icon1weatherLeft.setImage(fiveDaysFieldService.getNextDayIcon(weatherForApp, 0));
        icon2weatherLeft.setImage(fiveDaysFieldService.getNextDayIcon(weatherForApp, 1));
        icon3weatherLeft.setImage(fiveDaysFieldService.getNextDayIcon(weatherForApp, 2));
        icon4weatherLeft.setImage(fiveDaysFieldService.getNextDayIcon(weatherForApp, 3));
        icon5weatherLeft.setImage(fiveDaysFieldService.getNextDayIcon(weatherForApp, 4));

        temperature1Left.setText(fiveDaysFieldService.getDailyTemperatureNextDay(weatherForApp, 0)
                + " / " + fiveDaysFieldService.getNightTemperatureNextDay(weatherForApp, 0) + AnotherUtils.addTempUnit());
        temperature2Left.setText(fiveDaysFieldService.getDailyTemperatureNextDay(weatherForApp, 1)
                + " / " + fiveDaysFieldService.getNightTemperatureNextDay(weatherForApp, 1) + AnotherUtils.addTempUnit());
        temperature3Left.setText(fiveDaysFieldService.getDailyTemperatureNextDay(weatherForApp, 2)
                + " / " + fiveDaysFieldService.getNightTemperatureNextDay(weatherForApp, 2) + AnotherUtils.addTempUnit());
        temperature4Left.setText(fiveDaysFieldService.getDailyTemperatureNextDay(weatherForApp, 3)
                + " / " + fiveDaysFieldService.getNightTemperatureNextDay(weatherForApp, 3) + AnotherUtils.addTempUnit());
        temperature5Left.setText(fiveDaysFieldService.getDailyTemperatureNextDay(weatherForApp, 4)
                + " / " + fiveDaysFieldService.getNightTemperatureNextDay(weatherForApp, 4) + AnotherUtils.addTempUnit());
    }

}
