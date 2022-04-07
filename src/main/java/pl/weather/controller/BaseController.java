package pl.weather.controller;

import pl.weather.WeatherManager;
import pl.weather.view.ViewFactory;

public abstract class BaseController {

    private WeatherManager weatherManager;
    private ViewFactory viewFactory;
    private String fxml;

    public BaseController(WeatherManager weatherManager, ViewFactory viewFactory, String fxml) {
        this.weatherManager = weatherManager;
        this.viewFactory = viewFactory;
        this.fxml = fxml;
    }
}
