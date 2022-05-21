package pl.weather.model.auxiliaryMethods;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import pl.weather.controller.OpenWeatherAPIController;
import pl.weather.model.config.ConfigMainSettings;

import java.io.IOException;
import java.net.URL;
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
        while (scanner.hasNext()) {
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
        String wordAfter = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
        return wordAfter;
    }

    public static String getTextEnteredInTextField(TextField field){
        String textEnteredInField = field.getText().trim();
        textEnteredInField = StringMethods.writeFirstLetterCapitalize(textEnteredInField);
        return textEnteredInField;
    }

    public void setPanel(OpenWeatherAPIController openWeatherAPIController,
                         String city,
                         String country,
                         Label timeLabel,
                         Label cityLabel,
                         Label temperatureLabel,
                         Label pressureLabel,
                         Label humidityLabel,
                         ImageView imageView) {
        DateAndTimeMethods.updateClockNow(timeLabel, openWeatherAPIController.getTimezone());
        cityLabel.setText(city + ConfigMainSettings.SEPARATOR + country);
        temperatureLabel.setText(openWeatherAPIController.getCurrentTemperature() + StringMethods.addTempUnit());
        pressureLabel.setText(openWeatherAPIController.getCurrentPressure() + StringMethods.addPressureUnit());
        humidityLabel.setText(openWeatherAPIController.getCurrentHumidity() + StringMethods.addHumidityUnit());
        imageView.setImage(openWeatherAPIController.getCurrentDayIcon());
    }


}
