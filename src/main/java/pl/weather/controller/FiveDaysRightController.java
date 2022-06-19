package pl.weather.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import pl.weather.controller.service.OpenWeatherFiveDaysFieldService;
import pl.weather.model.auxiliary.DateAndTimeUtils;
import pl.weather.model.auxiliary.AnotherUtils;
import pl.weather.model.weather.WeatherForApp;

import java.net.MalformedURLException;

public class FiveDaysRightController  {

    @FXML
    private Label day1Right;

    @FXML
    private Label day2Right;

    @FXML
    private Label day3Right;

    @FXML
    private Label day4Right;

    @FXML
    private Label day5Right;

    @FXML
    private ImageView icon1weatherRight;

    @FXML
    private ImageView icon2weatherRight;

    @FXML
    private ImageView icon3weatherRight;

    @FXML
    private ImageView icon4weatherRight;

    @FXML
    private ImageView icon5weatherRight;

    @FXML
    private Label temperature1Right;

    @FXML
    private Label temperature2Right;

    @FXML
    private Label temperature3Right;

    @FXML
    private Label temperature4Right;

    @FXML
    private Label temperature5Right;

    public void setFiveDaysData(WeatherForApp weatherForApp) throws MalformedURLException {

        String timeZone = weatherForApp.getTimezone();
        OpenWeatherFiveDaysFieldService fiveDaysFieldService = new OpenWeatherFiveDaysFieldService();

        day1Right.setText(DateAndTimeUtils.getNextDayTextContent(timeZone, 1));
        day2Right.setText(DateAndTimeUtils.getNextDayTextContent(timeZone, 2));
        day3Right.setText(DateAndTimeUtils.getNextDayTextContent(timeZone, 3));
        day4Right.setText(DateAndTimeUtils.getNextDayTextContent(timeZone, 4));
        day5Right.setText(DateAndTimeUtils.getNextDayTextContent(timeZone, 5));

        icon1weatherRight.setImage(fiveDaysFieldService.getNextDayIcon(weatherForApp, 0));
        icon2weatherRight.setImage(fiveDaysFieldService.getNextDayIcon(weatherForApp, 1));
        icon3weatherRight.setImage(fiveDaysFieldService.getNextDayIcon(weatherForApp, 2));
        icon4weatherRight.setImage(fiveDaysFieldService.getNextDayIcon(weatherForApp, 3));
        icon5weatherRight.setImage(fiveDaysFieldService.getNextDayIcon(weatherForApp, 4));

        temperature1Right.setText(fiveDaysFieldService.getDailyTemperatureNextDay(weatherForApp, 0)
                + " / " + fiveDaysFieldService.getNightTemperatureNextDay(weatherForApp, 0) + AnotherUtils.addTempUnit());
        temperature2Right.setText(fiveDaysFieldService.getDailyTemperatureNextDay(weatherForApp, 1)
                + " / " + fiveDaysFieldService.getNightTemperatureNextDay(weatherForApp, 1) + AnotherUtils.addTempUnit());
        temperature3Right.setText(fiveDaysFieldService.getDailyTemperatureNextDay(weatherForApp, 2)
                + " / " + fiveDaysFieldService.getNightTemperatureNextDay(weatherForApp, 2) + AnotherUtils.addTempUnit());
        temperature4Right.setText(fiveDaysFieldService.getDailyTemperatureNextDay(weatherForApp, 3)
                + " / " + fiveDaysFieldService.getNightTemperatureNextDay(weatherForApp, 3) + AnotherUtils.addTempUnit());
        temperature5Right.setText(fiveDaysFieldService.getDailyTemperatureNextDay(weatherForApp, 4)
                + " / " + fiveDaysFieldService.getNightTemperatureNextDay(weatherForApp, 4) + AnotherUtils.addTempUnit());
    }
}
