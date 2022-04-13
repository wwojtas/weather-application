package pl.weather.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import pl.weather.controller.services.DateAndTimeMethods;

import java.net.URL;
import java.util.ResourceBundle;

public class FiveDaysLeftController implements Initializable {

        @FXML
        private Label day1Left;

        @FXML
        private Label day2Left;

        @FXML
        private Label day3Left;

        @FXML
        private Label day4Left;

        @FXML
        private Label day5Left;

        @FXML
        private ImageView icon1weatherLeft;

        @FXML
        private ImageView icon2weatherLeft;

        @FXML
        private ImageView icon3weatherLeft;

        @FXML
        private ImageView icon4weatherLeft;

        @FXML
        private ImageView icon5weatherLeft;

        @FXML
        private Label temperature1Left;

        @FXML
        private Label temperature2Left;

        @FXML
        private Label temperature3Left;

        @FXML
        private Label temperature4Left;

        @FXML
        private Label temperature5Left;


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            setDays();
        }


        public void setDays(){
            DateAndTimeMethods.setDayByLocalDate(day1Left, 1);
            DateAndTimeMethods.setDayByLocalDate(day2Left, 2);
            DateAndTimeMethods.setDayByLocalDate(day3Left, 3);
            DateAndTimeMethods.setDayByLocalDate(day4Left, 4);
            DateAndTimeMethods.setDayByLocalDate(day5Left, 5);
        }
}
