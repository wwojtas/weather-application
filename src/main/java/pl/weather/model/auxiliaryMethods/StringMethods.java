package pl.weather.model.auxiliaryMethods;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
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

    public static String readUrlAPI(String query) throws IOException {
        URL url = new URL(query);
        URLConnection urlConnection = url.openConnection();
        StringBuilder builder = new StringBuilder();
        Scanner scanner = null;
        try {
            scanner = new Scanner(urlConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()) {
            builder.append(scanner.nextLine());
        }
        scanner.close();
        return builder.toString();
    }
}
