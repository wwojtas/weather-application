package pl.weather;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import javafx.application.Application;
import javafx.stage.Stage;
import pl.weather.model.LocationUserData;
import pl.weather.model.WebServiceLocation;
import pl.weather.view.ViewFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.time.LocalTime;
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
        Locale defLoc = Locale.getDefault();
        System.out.println("Domyślna lokalizacja : " + defLoc);

        LocalTime localTime = LocalTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println(dtf.format(localTime));

        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
        String ip = in.readLine();
        System.out.println( new LocationUserData().getLocation().getCity());









    }

}

