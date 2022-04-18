package pl.weather.controller;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import pl.weather.model.GeoIP;
import pl.weather.model.LocationUserData;

import java.io.IOException;


public class LocationController  {

    private LocationUserData locationUserData;

    public LocationController() throws IOException {
        locationUserData = new LocationUserData();
    }

    public GeoIP getLocation() throws IOException, GeoIp2Exception {
        return locationUserData.getLocation();
    }
}
