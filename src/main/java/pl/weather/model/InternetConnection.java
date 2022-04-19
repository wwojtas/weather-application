package pl.weather.model;

import pl.weather.model.config.Config;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class InternetConnection {

    private static URL getUrlConnection(){
        try {
            return new URL(Config.CHECK_IP_URL_PATH);
        } catch (IOException e) {
            return null;
        }
    }

    protected String getIpAddress() {
        try {
            BufferedReader bufferedIP = new BufferedReader(new InputStreamReader(getUrlConnection().openStream()));
            return bufferedIP.readLine();
        } catch (IOException e) {
           return null;
        }
    }

    public static boolean isInternetConnection(){
        try {
            URLConnection urlConnection = getUrlConnection().openConnection();
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlConnection;
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.connect();
            int responseCode = httpsURLConnection.getResponseCode();
            if ( responseCode != 200 ) {
                throw new RuntimeException("HttpsResponseCode: " + responseCode);
            } else {
                return true;
            }
        } catch (IOException e) {
            return false;
        }
    }




}
