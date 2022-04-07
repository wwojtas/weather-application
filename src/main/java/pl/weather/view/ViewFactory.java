package pl.weather.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.weather.WeatherManager;
import pl.weather.controller.BaseController;
import pl.weather.controller.GeneralWindowController;

import java.io.IOException;

public class ViewFactory {

    private WeatherManager weatherManager;

    public ViewFactory(WeatherManager weatherManager) {
        this.weatherManager = weatherManager;
    }

    public void showGeneralWindow(){
        BaseController controller = new GeneralWindowController(weatherManager, this, "/fxml/GeneralWindow.fxml");
        FXMLLoader loader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        loader.setController(controller);
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }
}
