package pl.weather.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import pl.weather.WeatherManager;
import pl.weather.controller.services.Klasa;
import pl.weather.view.ViewFactory;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class GeneralWindowController extends BaseController implements Initializable {

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
    Klasa klasa = new Klasa();

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
        if(fieldIsValid(leftLocationField)){
            System.out.println("pole lewe");
        }
       if (fieldIsValid(rightLocationField)){
           System.out.println("pole prawe");
       }
    }

    private boolean fieldIsValid(TextField field){
        if( field.getText().isEmpty()) {
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
        klasa.updateClockNow(leftTimeField, flag);
        klasa.updateClockNow(rightTimeField, flag);
        updateMainDay();
    }

    private void updateMainDay() {
        LocalTime localTime = LocalTime.now();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.Y");
        final String currentDay = simpleDateFormat.format(new Date());
        currentDayLabel.setText(currentDay);

    }


}
