package pl.weather.model.auxiliaryMethods;

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

    public static String addTempUnit(){
        return ConfigMainSettings.TEMPERATURE_UNIT;
    }

    public static String addPressureUnit(){
        return ConfigMainSettings.PRESSURE_UNIT;
    }

    public static String addHumidityUnit(){
        return ConfigMainSettings.HUMIDITY_UNIT;
    }



}
