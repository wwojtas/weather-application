package pl.weather.model;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import java.io.IOException;
import java.net.InetAddress;

public class LocationUserData {

    public GeoIP getUserLocation(String userIpAdress)  {
        String ipAddress = new InternetConnection().getIpAddress(userIpAdress);
        CityResponse cityResponse = null;
        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            cityResponse = new DatabaseConnection().getDatabaseReader().city(inetAddress);
        } catch (IOException | GeoIp2Exception e) {
            e.printStackTrace();
        }
        String city = cityResponse.getCity().getName();
        String country = cityResponse.getCountry().getIsoCode();
        String latitude = cityResponse.getLocation().getLatitude().toString();
        String longitude = cityResponse.getLocation().getLongitude().toString();
        String timeZone = cityResponse.getLocation().getTimeZone();

        GeoIP geoIP = new GeoIP(ipAddress, city, country, latitude, longitude, timeZone);

        return geoIP;
    }


}



