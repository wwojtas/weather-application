package pl.weather.model;

import pl.weather.model.config.ConfigMainSettings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ConnectionToInternet {

    String getIpAddress(String path) throws MalformedURLException {
        URL url = new URL(path);
        try {
            BufferedReader bufferedIP = new BufferedReader(new InputStreamReader(url.openStream()));
            return bufferedIP.readLine();
        } catch (IOException e) {
           return null;
        }
    }

     boolean isHttpURLConnection(URL url) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if ( responseCode != 200 ) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                return true;
            }
        } catch (IOException e) {
            return false;
        }
    }

    public boolean checkInternetConnection(String ipAddress){
        try {
            URL url = new URL(ipAddress);
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            return true;
        } catch (IOException e) {
            return false;
        }

    }




}
