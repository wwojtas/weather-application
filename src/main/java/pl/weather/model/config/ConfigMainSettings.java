package pl.weather.model.config;

import com.google.gson.Gson;

public class ConfigMainSettings {

    // database
    public static final String GEOLITE2_DATABASE_PATH = "GeoLite2-City.mmdb";

    // check user IP
    public static final String CHECK_IP_URL_PATH_MAIN = "https://checkip.amazonaws.com";
    public static final String CHECK_IP_URL_PATH_SECOND = "https://ipinfo.io/ip";


    // date and hour
    public static final String CURRENT_DATE_PATTERN = "E dd.MM.yyyy";
    public static final String NEXT_DATE_PATTERN = "E dd.MM";
    public static final String CURRENT_TIME_PATTERN = "HH:mm";

    // units
    public static final String PRESSURE_UNIT = " hPa";
    public static final String HUMIDITY_UNIT = " %";
    public static final String TEMPERATURE_UNIT = " \u00B0C";
    public static final String SEPARATOR = ", ";

    // GSON
    public static final Gson createGsonStaticObject(){
        return new Gson();
    }

    // about application
    public static final String ABOUT_APPLICATION =
            "Aplikacja wyświetla aktualne warunki atmosferyczne:\n" +
                    "lokalizację i kod kraju, aktualny czas, \n" +
                    "temperaturę, ciśnienie i wilgotność powietrza, zachmurzenie. \n" +
                    "Aplikacja wyświetla również prognozę na 5 najbliższych dni.\n" +
                    "Domyślnie wyświetlane są warunki pogodowe dla pozycji użytkownika.\n" +
                    "Po wpisaniu w pole wyszukiwania i wybraniu opcji \"Aktualizuj pogodę\"\n " +
                    "wyświetla dane pogodowe dla wybranej lokalizacji\n" +
                    "Wadą aplikacji jest nieduża ilość miast.\n" +
                    "Wybrane lokalizacje pogodowe powinny obejmować miasta\n" +
                    "o większym znaczeniu administracyjnym w pobliżu użytkownika.\n";


}
