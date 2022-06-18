package pl.weather.model.auxiliaryMethods;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import pl.weather.controller.service.OpenWeatherFiveDaysFieldService;
import pl.weather.model.config.ConfigMainSettings;
import pl.weather.model.weather.WeatherForApp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class StringMethods {

    public static StringBuilder readAndCloseStringBuilder(URL urlConnect) {
        StringBuilder builder = new StringBuilder();
        Scanner scanner = null;
        try {
            scanner = new Scanner(urlConnect.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (Objects.requireNonNull(scanner).hasNext()) {
            builder.append(scanner.nextLine());
        }
        scanner.close();
        return builder;
    }

    public static String addTempUnit() {
        return ConfigMainSettings.TEMPERATURE_UNIT;
    }

    public static String addPressureUnit() {
        return ConfigMainSettings.PRESSURE_UNIT;
    }

    public static String addHumidityUnit() {
        return ConfigMainSettings.HUMIDITY_UNIT;
    }

    public static String writeFirstLetterCapitalize(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    public static String getTextEnteredInTextField(TextField field) {
        return StringMethods.writeFirstLetterCapitalize(field.getText().trim());
    }

    public void setPanel(WeatherForApp weatherForApp,
                         String city,
                         String country,
                         Label timeLabel,
                         Label cityLabel,
                         Label temperatureLabel,
                         Label pressureLabel,
                         Label humidityLabel,
                         ImageView imageView) throws MalformedURLException {
        DateAndTimeMethods.updateClock(timeLabel, weatherForApp.getTimezone());
        cityLabel.setText(city + ConfigMainSettings.SEPARATOR + country);
        temperatureLabel.setText(weatherForApp.getCurrentTemperature() + StringMethods.addTempUnit());
        pressureLabel.setText(weatherForApp.getCurrentPressure() + StringMethods.addPressureUnit());
        humidityLabel.setText(weatherForApp.getCurrentHumidity() + StringMethods.addHumidityUnit());
        imageView.setImage(new OpenWeatherFiveDaysFieldService().getCurrentDayIcon(weatherForApp));
    }


}
