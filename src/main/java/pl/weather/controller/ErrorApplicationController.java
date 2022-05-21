package pl.weather.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pl.weather.view.ViewFactory;

public class ErrorApplicationController extends BaseController {

    @FXML
    private Button confirmOKErrorButton;

    public ErrorApplicationController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    void confirmOKErrorApplication() {
        Stage stage = (Stage) confirmOKErrorButton.getScene().getWindow();
        stage.close();
    }

}
