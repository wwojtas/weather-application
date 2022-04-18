package pl.weather.model;

import com.maxmind.geoip2.WebServiceClient;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

public class WebServiceLocation {

    public final String ipUser = "37.225.68.113";


    public GeoIP getLocation() throws IOException, GeoIp2Exception {
        CityResponse response;
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
        String ip = in.readLine();
        try (WebServiceClient client = new WebServiceClient
                .Builder(705748, "88I0mrXaO8iEnrRc ")
                .build()) {
            InetAddress ipAddress = InetAddress.getByName(ip);
            response = client.city(ipAddress);
        }

        String countryIsoCode = response.getCountry().getIsoCode();
        String city = response.getCity().getName();
        String latitude = String.valueOf(response.getLocation().getLatitude());
        String longitude = String.valueOf(response.getLocation().getLongitude());

        GeoIP geoIP = new GeoIP(ip, city, countryIsoCode, latitude, longitude);

        return geoIP;
    }
}
