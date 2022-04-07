package pl.weather.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GeneralWindowController {

    @FXML
    public FiveDaysLeftController fiveDaysLeftController;

    @FXML
    public FiveDaysRightController fiveDaysRightController;

    @FXML
    private Button aboutAppButton;

    @FXML
    private Button closeAppButton;

    @FXML
    private Label leftCityLabel;

    @FXML
    private Label leftHumidityLabel;

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

    @FXML
    private Button updateWeatherButton;

    @FXML
    void closeApplication() {

    }

    @FXML
    void openAboutApplication() {

    }

    @FXML
    void updateWeather() {

    }


}
