package pl.weather.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pl.weather.WeatherManager;
import pl.weather.view.ViewFactory;

public class AboutApplicationController extends BaseController {

    @FXML
    private Label nameAppLabel;

    @FXML
    private Button okAboutButton;

    public AboutApplicationController(WeatherManager weatherManager, ViewFactory viewFactory, String fxmlName) {
        super(weatherManager, viewFactory, fxmlName);
    }

    @FXML
    void confirmAppButton() {
        Stage stage = (Stage) okAboutButton.getScene().getWindow();
        stage.close();
    }
}
