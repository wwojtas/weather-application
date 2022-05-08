package pl.weather.model;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class InternetConnection {

    protected String getIpAddress(String path) {
        try {
            URL url = new URL(path);
            BufferedReader bufferedIP = new BufferedReader(new InputStreamReader(url.openStream()));
            return bufferedIP.readLine();
        } catch (IOException e) {
           return null;
        }
    }

    public static boolean isHttpsURLConnection(URL url){
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
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

    public static boolean isHttpURLConnection(URL url){
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




}
