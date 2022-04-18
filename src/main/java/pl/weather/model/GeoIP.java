package pl.weather.model;

public class GeoIP {

    private String ipAddress;
    private String city;
    private String country;
    private String latitude;
    private String longitude;

    public GeoIP(String ipAddress, String city, String country, String latitude, String longitude) {
        this.ipAddress = ipAddress;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
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

    @Override
    public String toString() {
        return "GeoIP{" +
                "ipAddress='" + ipAddress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
