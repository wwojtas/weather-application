package pl.weather.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import pl.weather.controller.service.OpenWeatherAPIService;
import pl.weather.model.auxiliaryMethods.DateAndTimeMethods;
import pl.weather.model.auxiliaryMethods.StringMethods;

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


    public void setFiveDaysData(OpenWeatherAPIService openWeatherAPIService) throws MalformedURLException {

        String timeZone = openWeatherAPIService.getTimezone();

        DateAndTimeMethods.setTextNextDay(day1Right, timeZone, 1);
        DateAndTimeMethods.setTextNextDay(day2Right, timeZone, 2);
        DateAndTimeMethods.setTextNextDay(day3Right, timeZone, 3);
        DateAndTimeMethods.setTextNextDay(day4Right, timeZone, 4);
        DateAndTimeMethods.setTextNextDay(day5Right, timeZone, 5);

        icon1weatherRight.setImage(openWeatherAPIService.getNextDayIcon(0));
        icon2weatherRight.setImage(openWeatherAPIService.getNextDayIcon(1));
        icon3weatherRight.setImage(openWeatherAPIService.getNextDayIcon(2));
        icon4weatherRight.setImage(openWeatherAPIService.getNextDayIcon(3));
        icon5weatherRight.setImage(openWeatherAPIService.getNextDayIcon(4));

        temperature1Right.setText(openWeatherAPIService.getDailyTemperatureNextDay(0)
                + " / " + openWeatherAPIService.getNightTemperatureNextDay(0) + StringMethods.addTempUnit());
        temperature2Right.setText(openWeatherAPIService.getDailyTemperatureNextDay(1)
                + " / " + openWeatherAPIService.getNightTemperatureNextDay(1) + StringMethods.addTempUnit());
        temperature3Right.setText(openWeatherAPIService.getDailyTemperatureNextDay(2)
                + " / " + openWeatherAPIService.getNightTemperatureNextDay(2) + StringMethods.addTempUnit());
        temperature4Right.setText(openWeatherAPIService.getDailyTemperatureNextDay(3)
                + " / " + openWeatherAPIService.getNightTemperatureNextDay(3) + StringMethods.addTempUnit());
        temperature5Right.setText(openWeatherAPIService.getDailyTemperatureNextDay(4)
                + " / " + openWeatherAPIService.getNightTemperatureNextDay(4) + StringMethods.addTempUnit());
    }
}
