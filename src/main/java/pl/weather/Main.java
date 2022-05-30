package pl.weather;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.weather.model.ConnectionToInternet;
import pl.weather.model.config.ErrorMessages;
import pl.weather.view.ViewFactory;

import java.time.ZoneId;
import java.time.ZonedDateTime;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    ConnectionToInternet connectionToInternet = new ConnectionToInternet();

    @Override
    public void start(Stage stage) {

        ViewFactory viewFactory = new ViewFactory();
            if(connectionToInternet.checkInternetConnection()){
                viewFactory.showGeneralWindow();
            } else {
                viewFactory.showErrorApplication(ErrorMessages.INTERNET_CONNECTION_ERROR);
            }
    }

}

