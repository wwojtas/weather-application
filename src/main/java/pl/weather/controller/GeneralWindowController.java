package pl.weather.controller;

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

import java.net.URL;

import java.util.ResourceBundle;

public class GeneralWindowController extends BaseController implements Initializable {

//    LocationUserData locationUserData = new LocationUserData(new LocationCityAndCountry("Lublin", "Poland"));

    @FXML
    public FiveDaysLeftController fiveDaysLeftController;

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
    private Label leftTimeField;

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
    private Label rightTimeField;

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

    private boolean fieldIsValid(TextField field) {
        if (field.getText().isEmpty()) {
            field.setPromptText("lokalizacja, np.: Londyn");
            field.getParent().requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fieldIsValid(leftLocationField);
        fieldIsValid(rightLocationField);
        DateAndTimeMethods.updateClockNow(leftTimeField, flag);
        DateAndTimeMethods.updateClockNow(rightTimeField, flag);

        DateAndTimeMethods.setTextDayByLocalDate(currentDayLabel, 0);
        setLeftCityLabel();

    }

    private void setLeftCityLabel() {
        String cityName = new LocationUserData().getCityName();
        leftCityLabel.setText(cityName);
    }


}
