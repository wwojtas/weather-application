package pl.weather.model;

import java.io.File;
//import com.maxmind.geoip2.DatabaseReader;

public class LocationUserData{

    private String ipUser;
    private String dbLocation = "D:\\Nowy folder\\GeoLite2-City_20220412\\GeoLite2-City.mmdb";

    File file = new File(dbLocation);
//    DatabaseReader dbr = new DatabaseReader();

}
