package pl.weather.model.auxiliary;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import pl.weather.controller.service.OpenWeatherFiveDaysFieldService;
import pl.weather.model.config.ConfigMainSettings;
import pl.weather.model.config.ErrorMessages;
import pl.weather.model.weather.WeatherForApp;
import pl.weather.view.ViewFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class AnotherUtils {

    ViewFactory viewFactory = new ViewFactory();

    public StringBuilder readAndCloseStringBuilder(URL urlConnect) {
        StringBuilder builder = new StringBuilder();
        Scanner scanner = null;
        try {
            scanner = new Scanner(urlConnect.openStream());
        } catch (IOException e) {
            viewFactory.showErrorApplication(ErrorMessages.UNDEFINED_ERROR_READING_STREAM);
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
        return AnotherUtils.writeFirstLetterCapitalize(field.getText().trim());
    }

    public static void setPanel(WeatherForApp weatherForApp,
                         String city,
                         String country,
                         Label timeLabel,
                         Label cityLabel,
                         Label temperatureLabel,
                         Label pressureLabel,
                         Label humidityLabel,
                         ImageView imageView) throws MalformedURLException {
        timeLabel.setText(DateAndTimeUtils.updateClock(weatherForApp.getTimezone()));
        cityLabel.setText(city + ConfigMainSettings.SEPARATOR + country);
        temperatureLabel.setText(weatherForApp.getCurrentTemperature() + AnotherUtils.addTempUnit());
        pressureLabel.setText(weatherForApp.getCurrentPressure() + AnotherUtils.addPressureUnit());
        humidityLabel.setText(weatherForApp.getCurrentHumidity() + AnotherUtils.addHumidityUnit());
        imageView.setImage(new OpenWeatherFiveDaysFieldService().getCurrentDayIcon(weatherForApp));
    }


}
