package pl.weather.controller;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import pl.weather.WeatherManager;
import pl.weather.model.LocationUserData;
import pl.weather.model.auxiliaryMethods.DateAndTimeMethods;
import pl.weather.view.ViewFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class GeneralWindowController extends BaseController implements Initializable {


//    @FXML
//    public FiveDaysLeftController fiveDaysLeftController;

//    @FXML
//    public FiveDaysRightController fiveDaysRightController;

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
//        getWeatherInformation();

        updatePromptTextInFields();
        updateTimeFields();

        DateAndTimeMethods.setTextDayByLocalDate(currentDayLabel, 0);
        leftCityLabel.setText(getUserCityLocation() + "," + getUserCountryCodeLocation());
        rightCityLabel.setText(getUserCityLocation() + "," + getUserCountryCodeLocation());

    }

//    private void getWeatherInformation()  {
//        if( fieldIsValid(leftLocationField) ) {
//            OpenWeatherAPIController openWeatherAPIController = null;
//            String currentWeather = null;
//            try {
//                openWeatherAPIController = new OpenWeatherAPIController("Toronto");
//                openWeatherAPIController.getInformationAboutCity();
//                currentWeather = String.valueOf(openWeatherAPIController.getCurrentWeatherInformation());
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            System.out.println(currentWeather);
//        }
//    }

    private void updatePromptTextInFields(){
        fieldIsValid(leftLocationField);
        fieldIsValid(rightLocationField);
    }

    private boolean fieldIsValid(TextField field) {
        if (field.getText().isEmpty()) {
            field.setPromptText("lokalizacja, np.: Londyn");
            return false;
        }
        return true;
    }

    private void updateTimeFields(){
        DateAndTimeMethods.updateClockNow(leftTimeLabel, flag);
        DateAndTimeMethods.updateClockNow(rightTimeLabel, flag);
    }


    private String getUserCityLocation(){
        try {
            return new LocationUserData().getLocation().getCity();
        } catch (IOException | GeoIp2Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private String getUserCountryCodeLocation(){
        try {
            return new LocationUserData().getLocation().getCountry();
        } catch (IOException | GeoIp2Exception e) {
            e.printStackTrace();
        }
        return null;
    }















}
