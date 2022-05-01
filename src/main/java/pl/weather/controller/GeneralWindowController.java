package pl.weather.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import pl.weather.WeatherManager;
import pl.weather.model.*;
import pl.weather.model.auxiliaryMethods.DateAndTimeMethods;
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

        leftCityLabel.setText(currentUserLocationName + "," + country);
        rightCityLabel.setText(currentUserLocationName + "," + country);
        DateAndTimeMethods.updateClockNow(leftTimeLabel, flag, timeZone);
        DateAndTimeMethods.updateClockNow(rightTimeLabel, flag, timeZone);
        DateAndTimeMethods.setTextDay(currentDayLabel, timeZone, 0);
        String response = new OpenWeatherAPIController().getStringResponseToQueryWeather(latitude, longitude);
        Gson gson = new Gson();
        WeatherOneCall weatherOneCall = gson.fromJson(response, WeatherOneCall.class);

        leftTemperatureLabel.setText(weatherOneCall
                .getCurrent()
                .getTemp().toString());
        System.out.println(weatherOneCall.getCurrent().getHumidity());
        leftPressureLabel.setText(weatherOneCall
                .getCurrent()
                .getPressure()
                .toString());
        leftHumidityLabel.setText(weatherOneCall
                .getCurrent()
                .getHumidity()
                .toString());

        rightTemperatureLabel.setText(weatherOneCall
                .getCurrent()
                .getTemp().toString());
        System.out.println(weatherOneCall.getCurrent().getHumidity());
        rightPressureLabel.setText(weatherOneCall
                .getCurrent()
                .getPressure()
                .toString());
        rightHumidityLabel.setText(weatherOneCall
                .getCurrent()
                .getHumidity()
                .toString());



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
