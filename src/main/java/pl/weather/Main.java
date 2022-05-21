package pl.weather;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import javafx.application.Application;
import javafx.stage.Stage;
import pl.weather.controller.GeneralWindowController;
import pl.weather.controller.OpenWeatherAPIController;
import pl.weather.model.Connector;
import pl.weather.model.GeoIP;
import pl.weather.model.LocationUserData;
import pl.weather.model.auxiliaryMethods.StringMethods;
import pl.weather.model.config.ConfigMainSettings;
import pl.weather.view.ViewFactory;

import java.time.ZoneId;
import java.time.ZonedDateTime;


public class Main extends Application {
    public static void main(String[] args) throws GeoIp2Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showGeneralWindow();

//            viewFactory.showErrorApplication();
//        Locale defLoc = Locale.getDefault();
//        System.out.println("Domyślna lokalizacja : " + defLoc);
//
//        LocalTime localTime = LocalTime.now();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
//        System.out.println(dtf.format(localTime));
//

//
//        System.out.println(new OpenWeatherAPIController("London").getStringResponseToQueryWeather());
        System.out.println(ZonedDateTime.now(ZoneId.of("Europe/Madrid")));
//        GeoIP geoIP = new LocationUserData()
//                .getUserLocation(ConfigMainSettings.CHECK_IP_URL_PATH);
//        System.out.println(geoIP.getTimeZone());
//        String response = new Connector().getResponseFromQueryToAPI(query);
//        System.out.println(response);











    }

}

