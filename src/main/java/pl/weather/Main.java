package pl.weather;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import javafx.application.Application;
import javafx.stage.Stage;
import pl.weather.controller.OpenWeatherAPIController;
import pl.weather.model.InternetConnection;
import pl.weather.model.LocationUserData;
import pl.weather.view.ViewFactory;

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


        System.out.println( new LocationUserData().getLocation().getTimeZone());
//        System.out.println(InternetConnection.isInternetConnection());

//        System.out.println(new OpenWeatherAPIController("Lublin").getFiveDaysWeatherInformation().toJSONString());
//        System.out.println(new OpenWeatherAPIController("Lublin").getInformationAboutCity().getLocationName());
//        System.out.println(new OpenWeatherAPIController("Lublin").getInformationAboutCity().getCountryName());
        System.out.println(new OpenWeatherAPIController("Warsaw").getInformationAboutCity().getLocationName());
//        System.out.println(new OpenWeatherAPIController("Toronto").getCityInput());
//        System.out.println(new OpenWeatherAPIController("Toronto").getCurrentWeatherInformation());
//        System.out.println(new OpenWeatherAPIController("Toronto").getCurrentWeather());




//        System.out.println(new OpenWeatherAPIController("London").getCurrentWeatherInformation().toJSONString());








    }

}

