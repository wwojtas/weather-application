package pl.weather.controller;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.weather.WeatherManager;
import pl.weather.model.GeoIP;
import pl.weather.model.LocationUserData;
import pl.weather.model.WeatherOneCall;
import pl.weather.model.auxiliaryMethods.DateAndTimeMethods;
import pl.weather.model.config.ConfigAPIOpenWeather;
import pl.weather.model.config.ConfigMainSettings;
import pl.weather.view.ViewFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class GeneralWindowController extends BaseController implements Initializable {

    @FXML
    public FiveDaysRightController fiveDaysRightController;

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
        if (fieldIsValid(leftLocationField)) {
            System.out.println("pole lewe");
        }
        if (fieldIsValid(rightLocationField)) {
            System.out.println("pole prawe");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updatePromptTextInFields();
        getDefaultWeatherInformation();

    }

    private void getDefaultWeatherInformation() {
        GeoIP geoIP = new LocationUserData()
                .getLocation(ConfigMainSettings.CHECK_IP_URL_PATH);
        String currentUserLocationName = geoIP.getCity();
        String country = geoIP.getCountry();
        String latitude = geoIP.getLatitude();
        String longitude = geoIP.getLongitude();
        String timeZone = geoIP.getTimeZone();

        OpenWeatherAPIController openWeatherAPIController = new OpenWeatherAPIController(latitude, longitude);

        DateAndTimeMethods.setTextDay(currentDayLabel, timeZone, 0);
        DateAndTimeMethods.updateClockNow(leftTimeLabel, flag, timeZone);
        DateAndTimeMethods.updateClockNow(rightTimeLabel, flag, timeZone);

        leftCityLabel.setText(currentUserLocationName + "," + country);
        rightCityLabel.setText(currentUserLocationName + "," + country);

        leftTemperatureLabel.setText(openWeatherAPIController.getCurrentTemperature());
        leftPressureLabel.setText(openWeatherAPIController.getCurrentPressure());
        leftHumidityLabel.setText(openWeatherAPIController.getCurrentHumidity());

        rightTemperatureLabel.setText(openWeatherAPIController.getCurrentTemperature());
        rightPressureLabel.setText(openWeatherAPIController.getCurrentPressure());
        rightHumidityLabel.setText(openWeatherAPIController.getCurrentHumidity());

        leftImageView.setImage(openWeatherAPIController.getCurrentIcon());
        rightImageView.setImage(openWeatherAPIController.getCurrentIcon());


        // weather icons
//        String iconIDCurrentDay = weatherOneCall.getCurrent().getWeather().get(0).getIcon();
//        String iconID1day = weatherOneCall.getDaily().get(0).getWeather().get(0).getIcon();
//        String iconID2day = weatherOneCall.getDaily().get(1).getWeather().get(0).getIcon();
//        String iconID3day = weatherOneCall.getDaily().get(2).getWeather().get(0).getIcon();
//        String iconID4day = weatherOneCall.getDaily().get(3).getWeather().get(0).getIcon();
//        String iconID5day = weatherOneCall.getDaily().get(4).getWeather().get(0).getIcon();






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
