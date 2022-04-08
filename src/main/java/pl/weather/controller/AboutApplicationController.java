package pl.weather.controller;

import pl.weather.WeatherManager;
import pl.weather.view.ViewFactory;

public class AboutApplicationController extends BaseController {

    public AboutApplicationController(WeatherManager weatherManager, ViewFactory viewFactory, String fxmlName) {
        super(weatherManager, viewFactory, fxmlName);
    }
}
