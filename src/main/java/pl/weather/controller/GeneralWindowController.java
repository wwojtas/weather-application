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
        if (fieldIsBlank(leftLocationField)) {

            OpenWeatherGeocodingAPIController geocodingController =
                    new OpenWeatherGeocodingAPIController(getCityEnteredInField(leftLocationField));
            OpenWeatherAPIController openWeatherAPIController =
                    new OpenWeatherAPIController(geocodingController.getLatitude(),geocodingController.getLongitude());

            new StringMethods().setPanel(
                    openWeatherAPIController,
                    geocodingController.getCity(),
                    geocodingController.getCountry(),
                    leftTimeLabel,
                    leftCityLabel,
                    leftTemperatureLabel,
                    leftPressureLabel,
                    leftHumidityLabel,
                    leftImageView
            );
//            FiveDaysLeftController fiveDaysLeftController = new FiveDaysLeftController(openWeatherAPIController);
//            fiveDaysLeftController.setDaysData();
        }
    }

    private String getCityEnteredInField(TextField field) {
        String cityEnteredInField = field.getText().trim();
        cityEnteredInField = StringMethods.writeFirstLetterCapitalize(cityEnteredInField);
        return cityEnteredInField;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updatePromptTextInFields();
        getDefaultWeatherInformation();
    }

    private void getDefaultWeatherInformation() {
        GeoIP geoipLocation = new LocationUserData().getUserLocation(ConfigMainSettings.CHECK_IP_URL_PATH);
        OpenWeatherAPIController defaultWeatherController =
                new OpenWeatherAPIController(
                        geoipLocation.getLatitude(),
                        geoipLocation.getLongitude()
                );
        DateAndTimeMethods.setTextDay(currentDayLabel, defaultWeatherController.getTimezone(), 0);
        new StringMethods().setPanel(
                defaultWeatherController,
                geoipLocation.getCity(),
                geoipLocation.getCountry(),
                leftTimeLabel,
                leftCityLabel,
                leftTemperatureLabel,
                leftPressureLabel,
                leftHumidityLabel,
                leftImageView
        );
//        new FiveDaysLeftController(defaultWeatherController).setDaysData();
    }

    private void updatePromptTextInFields() {
        fieldIsBlank(leftLocationField);
        fieldIsBlank(rightLocationField);
    }

    private boolean fieldIsBlank(TextField field) {
        if (field.getText().isBlank()) {
            field.setText("");
            field.setPromptText("Lokalizacja");
            return false;
        }
        return true;
    }






//    private void setLeftPanel(OpenWeatherAPIController openWeatherAPIController, String city, String country) {
//        DateAndTimeMethods.updateClockNow(leftTimeLabel, openWeatherAPIController.getTimezone());
//        leftCityLabel.setText(city + ConfigMainSettings.SEPARATOR + country);
//        leftTemperatureLabel.setText(openWeatherAPIController.getCurrentTemperature() + StringMethods.addTempUnit());
//        leftPressureLabel.setText(openWeatherAPIController.getCurrentPressure() + StringMethods.addPressureUnit());
//        leftHumidityLabel.setText(openWeatherAPIController.getCurrentHumidity() + StringMethods.addHumidityUnit());
//        leftImageView.setImage(openWeatherAPIController.getCurrentDayIcon());
//    }

//    private void setRightPanel(OpenWeatherAPIController openWeatherAPIController) {
//        DateAndTimeMethods.updateClockNow(rightTimeLabel, flag, geoIPDefaultUserLocation.getTimeZone());
//        rightCityLabel.setText(geoIPDefaultUserLocation.getCity() + ConfigMainSettings.SEPARATOR + geoIPDefaultUserLocation.getCountry());
//        rightTemperatureLabel.setText(this.openWeatherAPIController.getCurrentTemperature() + StringMethods.addTempUnit());
//        rightPressureLabel.setText(this.openWeatherAPIController.getCurrentPressure() + StringMethods.addPressureUnit());
//        rightHumidityLabel.setText(this.openWeatherAPIController.getCurrentHumidity() + StringMethods.addHumidityUnit());
//        rightImageView.setImage(this.openWeatherAPIController.getCurrentDayIcon());
//    }

    //    private void setPanel(OpenWeatherAPIController openWeatherAPIController, String city, String country,
//                          Label timeLabel, Label cityLabel, Label temperatureLabel,
//                          Label pressureLabel, Label humidityLabel, ImageView imageView){
//        DateAndTimeMethods.updateClockNow(timeLabel, openWeatherAPIController.getTimezone());
//        cityLabel.setText(city + ConfigMainSettings.SEPARATOR + country);
//        temperatureLabel.setText(openWeatherAPIController.getCurrentTemperature() + StringMethods.addTempUnit());
//        pressureLabel.setText(openWeatherAPIController.getCurrentPressure() + StringMethods.addPressureUnit());
//        humidityLabel.setText(openWeatherAPIController.getCurrentHumidity() + StringMethods.addHumidityUnit());
//        imageView.setImage(openWeatherAPIController.getCurrentDayIcon());
//    }


}
