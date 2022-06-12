package pl.weather.model.config;

public class ConfigAPIOpenWeather {

    //  openWeather - GEOCODING LOCATION
    public static final String CITY_API_MAIN_QUERY = "http://api.openweathermap.org/geo/1.0/direct?q=";
    public static final String LIMIT_OF_LOCATIONS = "&limit=3";
    public static final String LOCAL_NAMES = "&local_names=pl";

    //  openWeather - weather data
    public static final String OPEN_WEATHER_ONE_CALL_MAIN_QUERY = "https://api.openweathermap.org/data/2.5/onecall?";
    public static final String LATITUDE_PREFIX = "lat=";
    public static final String LONGITUDE_PREFIX = "&lon=";
    public static final String EXCLUDE_PARAMETERS = "&exclude=minutely,hourly,alerts";
    public static final String BEFORE_API_KEY = "&appid=";
    public static final String UNITS_PARAMETER = "&units=metric";
    public static final String LANGUAGE_CODE = "&lang=pl";
    public static final int NUMBER_OF_DAYS = 4;

    // openWeather - icon data
    public static final String OPEN_WEATHER_ICON_CALL = "http://openweathermap.org/img/wn/";
    public static final String ICON_CALL_LAST_PARAMETER = "@2x.png";



}
