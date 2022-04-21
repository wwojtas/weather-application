package pl.weather.model.auxiliaryMethods;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class StringMethods {

    public static StringBuilder readAndCloseStringBuilder(URL url) {
        StringBuilder builder = new StringBuilder();
        Scanner scanner = null;
        try {
            scanner = new Scanner(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()) {
           builder.append(scanner.nextLine());
        }
        scanner.close();
        return builder;
    }
}
