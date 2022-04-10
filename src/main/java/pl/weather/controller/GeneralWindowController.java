package pl.weather.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import pl.weather.WeatherManager;
import pl.weather.model.TimeData;
import pl.weather.view.ViewFactory;

public class GeneralWindowController extends BaseController {

    private TimeData timeData;

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

    public GeneralWindowController(WeatherManager weatherManager, ViewFactory viewFactory, String fxmlName) {
        super(weatherManager, viewFactory, fxmlName);
    }

    @FXML
    void closeApplication() {

    }

    @FXML
    void openAboutApplication() {
        viewFactory.showAboutApplication();
    }

    @FXML
    void updateWeather() {
//        if(fieldIsValid(leftLocationField)){
//
//        }


    }

    private boolean fieldIsValid(TextField field){
        if( field.getText().isEmpty()) {
            field.setPromptText("lokalizacja, np.: Londyn");
            field.getParent().requestFocus();
            return false;
        }
        return true;
    }

    public void setDefaultValue(){
        while(true){
            Thread thread = new Thread(()->{
                leftTimeField.setText(timeData.getCurrentTime());
                try{
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }


    }



}
