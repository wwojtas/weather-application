package pl.weather.controller;

import pl.weather.WeatherManager;
import pl.weather.view.ViewFactory;

public abstract class BaseController {

    private WeatherManager weatherManager;
    private ViewFactory viewFactory;
    private String fxmlName;

    public BaseController(WeatherManager weatherManager, ViewFactory viewFactory, String fxmlName) {
        this.weatherManager = weatherManager;
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}
