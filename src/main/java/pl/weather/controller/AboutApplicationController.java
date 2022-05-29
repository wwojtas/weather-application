package pl.weather.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pl.weather.model.config.ConfigMainSettings;
import pl.weather.view.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutApplicationController extends BaseController implements Initializable {

    @FXML
    private Label aboutApplicationLabel;

    @FXML
    private Label nameAppLabel;

    @FXML
    private Button okAboutButton;

    public AboutApplicationController(ViewFactory viewFactory, String fxmlName) {
        super( viewFactory, fxmlName);
    }

    @FXML
    void confirmAppButton() {
        Stage stage = (Stage) okAboutButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        aboutApplicationLabel.setText(ConfigMainSettings.ABOUT_APPLICATION);
    }
}
