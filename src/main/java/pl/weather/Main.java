package pl.weather;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.weather.controller.GeneralWindowController;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GeneralWindow.fxml"));
            GeneralWindowController generalWindowController = new GeneralWindowController();
            loader.setController(generalWindowController);

            Parent parent =  loader.load();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
