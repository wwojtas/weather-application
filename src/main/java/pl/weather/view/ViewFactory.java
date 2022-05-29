package pl.weather.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.weather.controller.*;

import java.io.IOException;
import java.util.Objects;

public class ViewFactory {

    public ViewFactory() {
    }

    public void showGeneralWindow() {
        BaseController controller = new GeneralWindowController(this,
                "/fxml/GeneralWindow.fxml");
        initializeStage(controller);
    }

    public void showAboutApplication(){
        BaseController controller = new AboutApplicationController(this,
                "/fxml/AboutApplication.fxml");
        initializeStage(controller);
    }

    public void showErrorApplication(String errorMessage){
        BaseController controller = new ErrorApplicationController(this,
                "/fxml/ErrorApplication.fxml", errorMessage);
        initializeStage(controller);
    }

    private void initializeStage(BaseController controller){
        FXMLLoader loader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        loader.setController(controller);
        Parent parent;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
//        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/style.css")).toExternalForm());
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
