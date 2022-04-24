module weather {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires geoip2;
    requires maxmind.db;
    requires json.simple;
    requires com.google.gson;



    exports pl.weather;

    opens pl.weather.view;
    opens pl.weather.controller to javafx.fxml, javafx.controls;
    opens pl.weather.model to javafx.fxml, javafx.controls;
}