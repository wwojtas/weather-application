module weather {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires geoip2;
    requires maxmind.db;
    requires json.simple;
    requires com.google.gson;
    requires com.fasterxml.jackson.annotation;
    requires java.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;

    exports pl.weather;

    opens pl.weather.view;
    opens pl.weather.controller to javafx.fxml, javafx.controls;
    opens pl.weather.model to javafx.fxml, javafx.controls, com.google.gson;
    opens pl.weather to com.google.gson;
    opens pl.weather.model.weather to com.google.gson, javafx.controls, javafx.fxml;
    opens pl.weather.model.geocoding to  com.google.gson;
}