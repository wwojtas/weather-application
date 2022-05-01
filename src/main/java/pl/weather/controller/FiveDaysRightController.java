package pl.weather.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import pl.weather.model.GeoIP;
import pl.weather.model.LocationUserData;
import pl.weather.model.auxiliaryMethods.DateAndTimeMethods;
import pl.weather.model.config.ConfigMainSettings;

import java.net.URL;
import java.util.ResourceBundle;

public class FiveDaysRightController implements Initializable {

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDays();
    }


    public void setDays() {
        GeoIP geoIP = new LocationUserData()
                .getLocation(ConfigMainSettings.CHECK_IP_URL_PATH);
        String timeZone = geoIP.getTimeZone();
        DateAndTimeMethods.setTextNextDay(day1Right, timeZone, 1);
        DateAndTimeMethods.setTextNextDay(day2Right, timeZone, 2);
        DateAndTimeMethods.setTextNextDay(day3Right, timeZone, 3);
        DateAndTimeMethods.setTextNextDay(day4Right, timeZone, 4);
        DateAndTimeMethods.setTextNextDay(day5Right, timeZone, 5);
    }
}
