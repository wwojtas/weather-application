package pl.weather;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import javafx.application.Application;
import javafx.stage.Stage;
import pl.weather.model.ConnectionToInternet;
import pl.weather.model.config.ConfigMainSettings;
import pl.weather.model.config.ErrorMessages;
import pl.weather.view.ViewFactory;

import java.time.*;


public class Main extends Application {
    public static void main(String[] args) throws GeoIp2Exception {
        launch(args);
    }

    ConnectionToInternet connectionToInternet = new ConnectionToInternet();

    @Override
    public void start(Stage stage) throws Exception {

        ViewFactory viewFactory = new ViewFactory();
        if(connectionToInternet.checkInternetConnection()){
            viewFactory.showGeneralWindow();
        } else {
            viewFactory.showErrorApplication(ErrorMessages.INTERNET_CONNECTION_ERROR);
        }


        System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Tokyo")));
    }

}

