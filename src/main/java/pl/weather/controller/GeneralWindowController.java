package pl.weather.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import pl.weather.WeatherManager;
import pl.weather.view.ViewFactory;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class GeneralWindowController extends BaseController implements Initializable {

    @FXML
    public FiveDaysLeftController fiveDaysLeftController;

    @FXML
    public FiveDaysRightController fiveDaysRightController;

    @FXML
    private Button aboutAppButton;

    @FXML
    private Button closeAppButton;

    @FXML
    private Label currentDayLabel;

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

    @FXML
    private Button updateWeatherButton;
    private boolean flag = false;

    public GeneralWindowController(WeatherManager weatherManager, ViewFactory viewFactory, String fxmlName) {
        super(weatherManager, viewFactory, fxmlName);
    }

    @FXML
    public void closeApplication() {
        javafx.application.Platform.exit();
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
        updateClockNow(leftTimeField);
        updateClockNow(rightTimeField);

    }

    private void updateClockNow(Label timeField) {
        Thread thread = new Thread(()->{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            while(!flag){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String timeNow = simpleDateFormat.format(new Date());
                Platform.runLater(()->{
                    timeField.setText(timeNow);
                });

            }
        }); thread.start();
    }


}
