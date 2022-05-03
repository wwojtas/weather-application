package pl.weather.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.weather.model.GeoIP;
import pl.weather.model.LocationUserData;
import pl.weather.model.auxiliaryMethods.DateAndTimeMethods;
import pl.weather.model.config.ConfigMainSettings;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class FiveDaysLeftController implements Initializable {

    @FXML
    private Label day1Left;

    @FXML
    private Label day2Left;

    @FXML
    private Label day3Left;

    @FXML
    private Label day4Left;

    @FXML
    private Label day5Left;

    @FXML
    private ImageView icon1weatherLeft;

    @FXML
    private ImageView icon2weatherLeft;

    @FXML
    private ImageView icon3weatherLeft;

    @FXML
    private ImageView icon4weatherLeft;

    @FXML
    private ImageView icon5weatherLeft;

    @FXML
    private Label temperature1Left;

    @FXML
    private Label temperature2Left;

    @FXML
    private Label temperature3Left;

    @FXML
    private Label temperature4Left;

    @FXML
    private Label temperature5Left;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDaysData();
    }


    public void setDaysData() {
        GeoIP geoIP = new LocationUserData()
                .getLocation(ConfigMainSettings.CHECK_IP_URL_PATH);
        String timeZone = geoIP.getTimeZone();
        DateAndTimeMethods.setTextNextDay(day1Left, timeZone, 1);
        DateAndTimeMethods.setTextNextDay(day2Left, timeZone, 2);
        DateAndTimeMethods.setTextNextDay(day3Left, timeZone, 3);
        DateAndTimeMethods.setTextNextDay(day4Left, timeZone, 4);
        DateAndTimeMethods.setTextNextDay(day5Left, timeZone, 5);
    }
}
