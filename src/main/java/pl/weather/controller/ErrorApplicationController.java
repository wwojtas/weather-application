package pl.weather.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pl.weather.view.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ErrorApplicationController extends BaseController implements Initializable {

    private String errorMessage;

    @FXML
    private Label errorLabel;

    @FXML
    private Button confirmOKErrorButton;

    public ErrorApplicationController(ViewFactory viewFactory, String fxmlName, String errorMessage) {
        super(viewFactory, fxmlName);
        this.errorMessage = errorMessage;
    }

    @FXML
    void confirmOKErrorApplication() {
        Stage stage = (Stage) confirmOKErrorButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLabel.setText(errorMessage);
    }
}
