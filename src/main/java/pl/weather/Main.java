package pl.weather;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.weather.model.ConnectionToInternet;
import pl.weather.model.config.ConfigMainSettings;
import pl.weather.model.config.ErrorMessages;
import pl.weather.view.ViewFactory;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private final ConnectionToInternet connectionToInternet = new ConnectionToInternet();

    @Override
    public void start(Stage stage) {

        ViewFactory viewFactory = new ViewFactory();
            if(connectionToInternet.checkInternetConnection(ConfigMainSettings.CHECK_IP_URL_PATH_MAIN)
            || connectionToInternet.checkInternetConnection(ConfigMainSettings.CHECK_IP_URL_PATH_SECOND)){
                viewFactory.showGeneralWindow();
            } else {
                viewFactory.showErrorApplication(ErrorMessages.INTERNET_CONNECTION_ERROR);
            }
    }

}

