package pl.weather.controller;

import pl.weather.WeatherManager;
import pl.weather.view.ViewFactory;

public class ErrorApplicationController extends BaseController {

    public ErrorApplicationController(WeatherManager weatherManager, ViewFactory viewFactory, String fxmlName) {
        super(weatherManager, viewFactory, fxmlName);
    }

    @FXML
    void confirmOKErrorApplication() {

    }

}
