package pl.weather.model;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class LocationUserData{

    private final String ipUser = "37.225.68.113";
    private final String databaseLocation = "/database/GeoLite2-City.mmdb";

    private String getIpUser() {
        return ipUser;
    }

    private String getDatabaseLocation() {
        return databaseLocation;
    }

    private CityResponse getResponseFromDatabaseReader() throws IOException, GeoIp2Exception {
        File databaseFile = new File(getDatabaseLocation());
        DatabaseReader databaseReader = new DatabaseReader.Builder(databaseFile).build();
        InetAddress inetAddress = InetAddress.getByName(getIpUser());
        CityResponse cityResponse =  databaseReader.city(inetAddress);
        return cityResponse;
    }

    public String getCityName()  {
        String city = null;
        try {
            city = getResponseFromDatabaseReader().getCity().getName();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeoIp2Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    public String getCountryName()  {
        String country = null;
        try {
            country = getResponseFromDatabaseReader().getCountry().getName();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeoIp2Exception e) {
            e.printStackTrace();
        }
        return country;
    }







}
