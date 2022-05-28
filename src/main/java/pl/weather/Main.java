package pl.weather;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import javafx.application.Application;
import javafx.stage.Stage;
import pl.weather.view.ViewFactory;

import java.time.*;


public class Main extends Application {
    public static void main(String[] args) throws GeoIp2Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showGeneralWindow();

        System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Tokyo")));


    }

}

