package pl.weather.model;

public class GeoIP {

    private final String city;
    private final String country;
    private final String latitude;
    private final String longitude;

    public GeoIP( String city, String country, String latitude, String longitude) {
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
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

}
