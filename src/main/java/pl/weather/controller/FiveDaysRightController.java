package pl.weather.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import pl.weather.model.auxiliaryMethods.DateAndTimeMethods;

import java.net.URL;
import java.util.ResourceBundle;

public class FiveDaysRightController implements Initializable {

    @FXML
    private Label day1Right;

    @FXML
    private Label day2Right;

    @FXML
    private Label day3Right;

    @FXML
    private Label day4Right;

    @FXML
    private Label day5Right;

    @FXML
    private ImageView icon1weatherRight;

    @FXML
    private ImageView icon2weatherRight;

    @FXML
    private ImageView icon3weatherRight;

    @FXML
    private ImageView icon4weatherRight;

    @FXML
    private ImageView icon5weatherRight;

    @FXML
    private Label temperature1Right;

    @FXML
    private Label temperature2Right;

    @FXML
    private Label temperature3Right;

    @FXML
    private Label temperature4Right;

    @FXML
    private Label temperature5Right;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDays();
    }


    public void setDays(){
        DateAndTimeMethods.setTextDayByLocalDate(day1Right, 1);
        DateAndTimeMethods.setTextDayByLocalDate(day2Right, 2);
        DateAndTimeMethods.setTextDayByLocalDate(day3Right, 3);
        DateAndTimeMethods.setTextDayByLocalDate(day4Right, 4);
        DateAndTimeMethods.setTextDayByLocalDate(day5Right, 5);
    }
}
