module weather {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;
    requires java.desktop;

    exports pl.weather;

    opens pl.weather.controller to javafx.fxml;
}