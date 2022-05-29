package pl.weather.controller;

import pl.weather.view.ViewFactory;

public abstract class BaseController {

    protected ViewFactory viewFactory;
    private final String fxmlName;

    public BaseController( ViewFactory viewFactory, String fxmlName) {
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }


}
