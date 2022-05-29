package pl.weather.controller;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import pl.weather.controller.service.OpenWeatherAPIController;
import pl.weather.controller.service.OpenWeatherGeocodingAPIController;
import pl.weather.model.GeoIP;
import pl.weather.model.LocationUserData;
import pl.weather.model.auxiliaryMethods.DateAndTimeMethods;
import pl.weather.model.auxiliaryMethods.StringMethods;
import pl.weather.model.config.ConfigMainSettings;
import pl.weather.model.config.ErrorMessages;
import pl.weather.view.ViewFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class GeneralWindowController extends BaseController implements Initializable {

    @FXML
    private FiveDaysLeftController fiveDaysLeftController;

    @FXML
    private FiveDaysRightController fiveDaysRightController;

    @FXML
    private Label rightCurrentDayLabel;

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
    private Label leftCurrentDayLabel;

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


    public GeneralWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fieldIsBlank(leftLocationField);
        fieldIsBlank(rightLocationField);
        setDefaultWeatherDataInLeftPanel();
        setDefaultWeatherDataInRightPanel();
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
        if ( fieldIsBlank(leftLocationField) ) {
            OpenWeatherGeocodingAPIController geocodingController = getOpenWeatherGeocodingAPIController(leftLocationField);
            try {
                OpenWeatherAPIController openWeatherAPIController =
                        new OpenWeatherAPIController(geocodingController.getLatitude(), geocodingController.getLongitude());
                DateAndTimeMethods.setTextDay(leftCurrentDayLabel, openWeatherAPIController.getTimezone(), 0);
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
                fiveDaysLeftController.setFiveDaysData(openWeatherAPIController);
            } catch (MalformedURLException e) {
                viewFactory.showErrorApplication(ErrorMessages.MALFORMED_URL_ADDRESS);
            }
        } else {
            setDefaultWeatherDataInLeftPanel();
        }

        if( fieldIsBlank(rightLocationField) ){
            OpenWeatherGeocodingAPIController geocodingController = getOpenWeatherGeocodingAPIController(rightLocationField);
            try {
                OpenWeatherAPIController openWeatherAPIController =
                        new OpenWeatherAPIController(geocodingController.getLatitude(), geocodingController.getLongitude());
                DateAndTimeMethods.setTextDay(rightCurrentDayLabel, openWeatherAPIController.getTimezone(), 0);
                new StringMethods().setPanel(
                        openWeatherAPIController,
                        geocodingController.getCity(),
                        geocodingController.getCountry(),
                        rightTimeLabel,
                        rightCityLabel,
                        rightTemperatureLabel,
                        rightPressureLabel,
                        rightHumidityLabel,
                        rightImageView
                );
                fiveDaysRightController.setFiveDaysData(openWeatherAPIController);
            } catch (MalformedURLException e) {
                viewFactory.showErrorApplication(ErrorMessages.MALFORMED_URL_ADDRESS);
            }
        } else {
            setDefaultWeatherDataInRightPanel();
        }
    }

    private void setDefaultWeatherDataInLeftPanel()  {
        OpenWeatherAPIController defaultWeatherController = null;
        try {
            defaultWeatherController = new OpenWeatherAPIController(getGeoIP().getLatitude(), getGeoIP().getLongitude());
            DateAndTimeMethods.setTextDay(leftCurrentDayLabel, defaultWeatherController.getTimezone(), 0);
            new StringMethods().setPanel(
                    defaultWeatherController,
                    getGeoIP().getCity(),
                    getGeoIP().getCountry(),
                    leftTimeLabel,
                    leftCityLabel,
                    leftTemperatureLabel,
                    leftPressureLabel,
                    leftHumidityLabel,
                    leftImageView
            );
        } catch (IOException e) {
            viewFactory.showErrorApplication(ErrorMessages.INTERNET_CONNECTION_ERROR);
        } catch (GeoIp2Exception e) {
            viewFactory.showErrorApplication(ErrorMessages.USER_LOCATION_OR_DATABASE_CONNECTION_ERROR);
        }
        try {
            fiveDaysLeftController.setFiveDaysData(defaultWeatherController);
        } catch (MalformedURLException e) {
            viewFactory.showErrorApplication(ErrorMessages.MALFORMED_URL_ADDRESS);
        }
    }

    private void setDefaultWeatherDataInRightPanel(){
        OpenWeatherAPIController defaultWeatherController = null;
        try {
            defaultWeatherController = new OpenWeatherAPIController(getGeoIP().getLatitude(), getGeoIP().getLongitude());
            DateAndTimeMethods.setTextDay(rightCurrentDayLabel, defaultWeatherController.getTimezone(), 0);
            new StringMethods().setPanel(
                    defaultWeatherController,
                    getGeoIP().getCity(),
                    getGeoIP().getCountry(),
                    rightTimeLabel,
                    rightCityLabel,
                    rightTemperatureLabel,
                    rightPressureLabel,
                    rightHumidityLabel,
                    rightImageView
            );
        } catch (IOException e) {
            viewFactory.showErrorApplication(ErrorMessages.INTERNET_CONNECTION_ERROR);
        } catch (GeoIp2Exception e) {
            viewFactory.showErrorApplication(ErrorMessages.USER_LOCATION_OR_DATABASE_CONNECTION_ERROR);
        }
        try {
            fiveDaysRightController.setFiveDaysData(defaultWeatherController);
        } catch (MalformedURLException e) {
            viewFactory.showErrorApplication(ErrorMessages.MALFORMED_URL_ADDRESS);
        }
    }

    private GeoIP getGeoIP() throws IOException, GeoIp2Exception {
        GeoIP geoipLocation = new LocationUserData().getUserLocationBasedIPAddress(ConfigMainSettings.CHECK_IP_URL_PATH);
        return geoipLocation;
    }

    private OpenWeatherGeocodingAPIController getOpenWeatherGeocodingAPIController(TextField textField) {
        OpenWeatherGeocodingAPIController geocodingController =
                new OpenWeatherGeocodingAPIController(StringMethods.getTextEnteredInTextField(textField));
        return geocodingController;
    }

    private boolean fieldIsBlank(TextField field) {
        if (field.getText().isBlank()) {
            field.setText("");
            field.setPromptText("Lokalizacja");
            return false;
        }
        return true;
    }

}
