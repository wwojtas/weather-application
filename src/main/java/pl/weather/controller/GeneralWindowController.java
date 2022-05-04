package pl.weather.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import pl.weather.WeatherManager;
import pl.weather.model.GeoIP;
import pl.weather.model.LocationUserData;
import pl.weather.model.auxiliaryMethods.DateAndTimeMethods;
import pl.weather.model.auxiliaryMethods.StringMethods;
import pl.weather.model.config.ConfigMainSettings;
import pl.weather.view.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class GeneralWindowController extends BaseController implements Initializable {


    @FXML
    private Label currentDayLabel;

    @FXML
    private Button aboutAppButton;

    @FXML
    private Button closeAppButton;

    @FXML
    private Button updateWeatherButton;

    @FXML
    private Label leftCityLabel;

    @FXML
    private Label leftHumidityLabel;

    @FXML
    private ImageView leftImageView;

    @FXML
    private ImageView rightImageView;

    @FXML
    private TextField leftLocationField;

    @FXML
    private Label leftPressureLabel;

    @FXML
    private Label leftTemperatureLabel;

    @FXML
    private Label leftTimeLabel;

    @FXML
    private Label rightCityLabel;

    @FXML
    private Label rightHumidityLabel;

    @FXML
    private TextField rightLocationField;

    @FXML
    private Label rightPressureLabel;

    @FXML
    private Label rightTemperatureLabel;

    @FXML
    private Label rightTimeLabel;

    private boolean flag = false;

    public GeneralWindowController(WeatherManager weatherManager, ViewFactory viewFactory, String fxmlName) {
        super(weatherManager, viewFactory, fxmlName);
    }

    @FXML
    public void closeApplication() {
        javafx.application.Platform.exit();
        System.exit(0);
    }

    @FXML
    public void openAboutApplication() {
        viewFactory.showAboutApplication();
    }

    @FXML
    public void updateWeather() {
        if ( fieldIsValid(leftLocationField)) {
            if(fieldIsValid(rightLocationField)){
                getDefaultWeatherInformation();
            }
            getDefaultWeatherInformation();
        } else {
            String leftLocation = leftLocationField.getText();

        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updatePromptTextInFields();
        getDefaultWeatherInformation();

    }

    private void getDefaultWeatherInformation() {
        GeoIP geoIP = new LocationUserData()
                .getUserLocation(ConfigMainSettings.CHECK_IP_URL_PATH);
        String currentUserLocationName = geoIP.getCity();
        String country = geoIP.getCountry();

        OpenWeatherAPIController openWeatherAPIController =
                new OpenWeatherAPIController(geoIP.getLatitude(), geoIP.getLongitude());

        DateAndTimeMethods.setTextDay(currentDayLabel, geoIP.getTimeZone(), 0);
        DateAndTimeMethods.updateClockNow(leftTimeLabel, flag, geoIP.getTimeZone());
        DateAndTimeMethods.updateClockNow(rightTimeLabel, flag, geoIP.getTimeZone());

        leftCityLabel.setText(currentUserLocationName + "," + country);
        rightCityLabel.setText(currentUserLocationName + "," + country);
        leftTemperatureLabel.setText(openWeatherAPIController.getCurrentTemperature() + StringMethods.addTempUnit());
        leftPressureLabel.setText(openWeatherAPIController.getCurrentPressure() + StringMethods.addPressureUnit());
        leftHumidityLabel.setText(openWeatherAPIController.getCurrentHumidity() + StringMethods.addHumidityUnit());
        rightTemperatureLabel.setText(openWeatherAPIController.getCurrentTemperature() + StringMethods.addTempUnit());
        rightPressureLabel.setText(openWeatherAPIController.getCurrentPressure() + StringMethods.addPressureUnit());
        rightHumidityLabel.setText(openWeatherAPIController.getCurrentHumidity() + StringMethods.addHumidityUnit());
        leftImageView.setImage(openWeatherAPIController.getCurrentDayIcon());
        rightImageView.setImage(openWeatherAPIController.getCurrentDayIcon());


    }



    private void updatePromptTextInFields() {
        fieldIsValid(leftLocationField);
        fieldIsValid(rightLocationField);
    }

    private boolean fieldIsValid(TextField field) {
        if (field.getText().isEmpty()) {
            field.setPromptText("Lokalizacja");
            return false;
        }
        return true;
    }






}
