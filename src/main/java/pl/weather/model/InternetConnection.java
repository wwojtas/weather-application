package pl.weather.model;

import pl.weather.model.config.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    protected boolean isInternetConnection(){
        try {
            URLConnection urlConnection = getUrlConnection().openConnection();
            urlConnection.connect();
            return true;
        } catch (IOException e) {
            return false;
        }
    }




}
