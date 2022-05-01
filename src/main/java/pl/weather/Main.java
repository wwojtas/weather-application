package pl.weather;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import javafx.application.Application;
import javafx.stage.Stage;
import pl.weather.controller.OpenWeatherAPIController;
import pl.weather.model.GeoIP;
import pl.weather.model.LocationUserData;
import pl.weather.model.WeatherOneCall;
import pl.weather.model.config.ConfigMainSettings;
import pl.weather.view.ViewFactory;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class Main extends Application {
    public static void main(String[] args) throws GeoIp2Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ViewFactory viewFactory = new ViewFactory(new WeatherManager());
        viewFactory.showGeneralWindow();

//            viewFactory.showErrorApplication();
//        Locale defLoc = Locale.getDefault();
//        System.out.println("Domyślna lokalizacja : " + defLoc);
//
//        LocalTime localTime = LocalTime.now();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
//        System.out.println(dtf.format(localTime));
//

//        String lat =  new LocationUserData().getLocation().getLatitude();
//        String lon =  new LocationUserData().getLocation().getLongitude();
//        String current = "current";
//        String daily = "daily";
//
//        System.out.println(new OpenWeatherAPIController("London").getStringResponseToQueryWeather());
        System.out.println(ZonedDateTime.now(ZoneId.of("Europe/Madrid")));
        GeoIP geoIP = new LocationUserData()
                .getLocation(ConfigMainSettings.CHECK_IP_URL_PATH);
        System.out.println(geoIP.getTimeZone());











    }

}

