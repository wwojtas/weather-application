package pl.weather.model;

import pl.weather.model.auxiliaryMethods.AnotherUtils;

import java.net.MalformedURLException;
import java.net.URL;

public class ConnectionToOpenWeather {

    public String getResponseFromQueryToAPI(String queryToAPI) throws MalformedURLException {
        URL urlConnect = new URL(queryToAPI);
        if( new ConnectionToInternet().isHttpURLConnection(urlConnect)) {
            StringBuilder informationString = new AnotherUtils().readAndCloseStringBuilder(urlConnect);
            return informationString.toString();
        }
        return null;
    }


}


