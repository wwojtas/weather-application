package pl.weather.model;

public class Location {

    private String locationName;
    private String countryName;
    private double longitude;
    private double latitude;


    public Location(String locationName, String countryName, double longitude, double latitude) {
        this.locationName = locationName;
        this.countryName = countryName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getCountryName() {
        return countryName;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
