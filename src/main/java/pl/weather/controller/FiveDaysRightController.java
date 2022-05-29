package pl.weather.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import pl.weather.controller.service.OpenWeatherAPIController;
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


    public void setFiveDaysData(OpenWeatherAPIController openWeatherAPIController) throws MalformedURLException {

        String timeZone = openWeatherAPIController.getTimezone();

        DateAndTimeMethods.setTextNextDay(day1Right, timeZone, 1);
        DateAndTimeMethods.setTextNextDay(day2Right, timeZone, 2);
        DateAndTimeMethods.setTextNextDay(day3Right, timeZone, 3);
        DateAndTimeMethods.setTextNextDay(day4Right, timeZone, 4);
        DateAndTimeMethods.setTextNextDay(day5Right, timeZone, 5);

        icon1weatherRight.setImage(openWeatherAPIController.getNextDayIcon(0));
        icon2weatherRight.setImage(openWeatherAPIController.getNextDayIcon(1));
        icon3weatherRight.setImage(openWeatherAPIController.getNextDayIcon(2));
        icon4weatherRight.setImage(openWeatherAPIController.getNextDayIcon(3));
        icon5weatherRight.setImage(openWeatherAPIController.getNextDayIcon(4));

        temperature1Right.setText(openWeatherAPIController.getDailyTemperatureNextDay(0)
                + " / " + openWeatherAPIController.getNightTemperatureNextDay(0) + StringMethods.addTempUnit());
        temperature2Right.setText(openWeatherAPIController.getDailyTemperatureNextDay(1)
                + " / " + openWeatherAPIController.getNightTemperatureNextDay(1) + StringMethods.addTempUnit());
        temperature3Right.setText(openWeatherAPIController.getDailyTemperatureNextDay(2)
                + " / " + openWeatherAPIController.getNightTemperatureNextDay(2) + StringMethods.addTempUnit());
        temperature4Right.setText(openWeatherAPIController.getDailyTemperatureNextDay(3)
                + " / " + openWeatherAPIController.getNightTemperatureNextDay(3) + StringMethods.addTempUnit());
        temperature5Right.setText(openWeatherAPIController.getDailyTemperatureNextDay(4)
                + " / " + openWeatherAPIController.getNightTemperatureNextDay(4) + StringMethods.addTempUnit());
    }
}
