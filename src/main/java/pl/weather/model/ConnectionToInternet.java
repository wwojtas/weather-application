package pl.weather.model;

import pl.weather.model.config.ConfigMainSettings;
import pl.weather.view.ViewFactory;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ConnectionToInternet {

    String getIpAddress(String path) {
        try {
            URL url = new URL(path);
            BufferedReader bufferedIP = new BufferedReader(new InputStreamReader(url.openStream()));
            return bufferedIP.readLine();
        } catch (IOException e) {
           return null;
        }
    }

     boolean isHttpURLConnection(URL url){
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

    public boolean checkInternetConnection() {
        try {
            URL url = new URL(ConfigMainSettings.CHECK_IP_URL_PATH);
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            return true;
        } catch (IOException e) {
            return false;
        }

    }



//    public static boolean isHttpsURLConnection(URL url){
//        try {
//            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
//            httpsURLConnection.setRequestMethod("GET");
//            httpsURLConnection.connect();
//            int responseCode = httpsURLConnection.getResponseCode();
//            if ( responseCode != 200 ) {
//                throw new RuntimeException("HttpsResponseCode: " + responseCode);
//            } else {
//                return true;
//            }
//        } catch (IOException e) {
//            return false;
//        }
//    }






}
