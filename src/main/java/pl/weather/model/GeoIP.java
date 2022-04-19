package pl.weather.model;

public class GeoIP {

    private String ipAddress;
    private String city;
    private String country;
    private String latitude;
    private String longitude;
    private String timeZone;

    public GeoIP(String ipAddress, String city, String country, String latitude, String longitude, String timeZone) {
        this.ipAddress = ipAddress;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timeZone = timeZone;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getTimeZone() {
        return timeZone;
    }
}
