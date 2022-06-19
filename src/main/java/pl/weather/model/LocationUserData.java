package pl.weather.model;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import java.io.IOException;
import java.net.InetAddress;

public class LocationUserData {

    public GeoIP getUserLocationBasedIPAddress(String userIpAddress) throws IOException, GeoIp2Exception {
        String ipAddress = new ConnectionToInternet().getIpAddress(userIpAddress);
        InetAddress inetAddress = InetAddress.getByName(ipAddress);
        CityResponse cityResponse = new ConnectionToDatabase().getDatabaseReader().city(inetAddress);
        String city = cityResponse.getCity().getName();
        String country = cityResponse.getCountry().getIsoCode();
        String latitude = cityResponse.getLocation().getLatitude().toString();
        String longitude = cityResponse.getLocation().getLongitude().toString();

        return new GeoIP(city, country, latitude, longitude);
    }


}



