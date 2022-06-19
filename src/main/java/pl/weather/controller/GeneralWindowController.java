package pl.weather.controller;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import pl.weather.controller.service.OpenWeatherAPIService;
import pl.weather.controller.service.OpenWeatherGeocodingAPIService;
import pl.weather.model.GeoIP;
import pl.weather.model.LocationUserData;
import pl.weather.model.auxiliaryMethods.DateAndTimeUtils;
import pl.weather.model.auxiliaryMethods.AnotherUtils;
import pl.weather.model.config.ConfigMainSettings;
import pl.weather.model.config.ErrorMessages;
import pl.weather.model.weather.WeatherForApp;
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
        Platform.exit();
        System.exit(0);
    }

    @FXML
    public void openAboutApplication() {
        viewFactory.showAboutApplication();
    }

    @FXML
    public void updateWeather() {
        if (fieldIsBlank(leftLocationField)) {
            OpenWeatherGeocodingAPIService geocodingAPIService = getOpenWeatherGeocodingAPIService(leftLocationField);
            try {
                GeoIP geoIPGeocoding = geocodingAPIService.getGeocodingFromOpenWeather();
                WeatherForApp weatherForApp = new OpenWeatherAPIService(geoIPGeocoding.getLatitude(), geoIPGeocoding.getLongitude())
                        .getWeatherForAppObject();
                leftCurrentDayLabel.setText(DateAndTimeUtils.getDayTextContent(weatherForApp.getTimezone(), 0));
                AnotherUtils.setPanel(
                        weatherForApp,
                        geoIPGeocoding.getCity(),
                        geoIPGeocoding.getCountry(),
                        leftTimeLabel,
                        leftCityLabel,
                        leftTemperatureLabel,
                        leftPressureLabel,
                        leftHumidityLabel,
                        leftImageView
                );
                fiveDaysLeftController.setFiveDaysData(weatherForApp);
            } catch (MalformedURLException e) {
                viewFactory.showErrorApplication(ErrorMessages.MALFORMED_URL_ADDRESS);
            }
        } else {
            setDefaultWeatherDataInLeftPanel();
        }

        if (fieldIsBlank(rightLocationField)) {
            OpenWeatherGeocodingAPIService geocodingAPIService = getOpenWeatherGeocodingAPIService(rightLocationField);
            try {
                GeoIP geoIPGeocoding = geocodingAPIService.getGeocodingFromOpenWeather();
                WeatherForApp weatherForApp = new OpenWeatherAPIService(geoIPGeocoding.getLatitude(), geoIPGeocoding.getLongitude())
                        .getWeatherForAppObject();
                rightCurrentDayLabel.setText(DateAndTimeUtils.getDayTextContent(weatherForApp.getTimezone(), 0));
                AnotherUtils.setPanel(
                        weatherForApp,
                        geoIPGeocoding.getCity(),
                        geoIPGeocoding.getCountry(),
                        rightTimeLabel,
                        rightCityLabel,
                        rightTemperatureLabel,
                        rightPressureLabel,
                        rightHumidityLabel,
                        rightImageView
                );
                fiveDaysRightController.setFiveDaysData(weatherForApp);
            } catch (MalformedURLException e) {
                viewFactory.showErrorApplication(ErrorMessages.MALFORMED_URL_ADDRESS);
            }
        } else {
            setDefaultWeatherDataInRightPanel();
        }
    }

    private void setDefaultWeatherDataInLeftPanel() {
        try {
            GeoIP defaultGeoip = getUserLocationByGeoip();
            WeatherForApp defaultWeatherForApp = new OpenWeatherAPIService(defaultGeoip.getLatitude(), defaultGeoip.getLongitude()).getWeatherForAppObject();
            leftCurrentDayLabel.setText(DateAndTimeUtils.getDayTextContent(defaultWeatherForApp.getTimezone(), 0));
            AnotherUtils.setPanel(
                    defaultWeatherForApp,
                    defaultGeoip.getCity(),
                    defaultGeoip.getCountry(),
                    leftTimeLabel,
                    leftCityLabel,
                    leftTemperatureLabel,
                    leftPressureLabel,
                    leftHumidityLabel,
                    leftImageView
            );
            fiveDaysLeftController.setFiveDaysData(defaultWeatherForApp);
        } catch (MalformedURLException e) {
            viewFactory.showErrorApplication(ErrorMessages.MALFORMED_URL_ADDRESS);
        } catch (IOException e) {
            viewFactory.showErrorApplication(ErrorMessages.INTERNET_CONNECTION_ERROR);
        } catch (GeoIp2Exception e) {
            viewFactory.showErrorApplication(ErrorMessages.USER_LOCATION_OR_DATABASE_CONNECTION_ERROR);
        }
    }

    private void setDefaultWeatherDataInRightPanel() {
        try {
            GeoIP defaultGeoip = getUserLocationByGeoip();
            WeatherForApp defaultWeatherForApp = new OpenWeatherAPIService(defaultGeoip.getLatitude(), defaultGeoip.getLongitude()).getWeatherForAppObject();
            rightCurrentDayLabel.setText(DateAndTimeUtils.getDayTextContent(defaultWeatherForApp.getTimezone(), 0));
            AnotherUtils.setPanel(
                    defaultWeatherForApp,
                    defaultGeoip.getCity(),
                    defaultGeoip.getCountry(),
                    rightTimeLabel,
                    rightCityLabel,
                    rightTemperatureLabel,
                    rightPressureLabel,
                    rightHumidityLabel,
                    rightImageView
            );
            fiveDaysRightController.setFiveDaysData(defaultWeatherForApp);
        } catch (MalformedURLException e) {
            viewFactory.showErrorApplication(ErrorMessages.MALFORMED_URL_ADDRESS);
        } catch (IOException e) {
            viewFactory.showErrorApplication(ErrorMessages.INTERNET_CONNECTION_ERROR);
        } catch (GeoIp2Exception e) {
            viewFactory.showErrorApplication(ErrorMessages.USER_LOCATION_OR_DATABASE_CONNECTION_ERROR);
        }
    }

    private GeoIP getUserLocationByGeoip() throws IOException, GeoIp2Exception {
        return new LocationUserData().getUserLocationBasedIPAddress(ConfigMainSettings.CHECK_IP_URL_PATH_MAIN);
    }

    private OpenWeatherGeocodingAPIService getOpenWeatherGeocodingAPIService(TextField textField) {
        return new OpenWeatherGeocodingAPIService(AnotherUtils.getTextEnteredInTextField(textField));
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
