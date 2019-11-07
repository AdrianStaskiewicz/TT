//import entities.general.Address;
import controllers.LoginScreenController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import parameters.ParameterProvider;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Locale.setDefault(new Locale("en", "GB"));

        FXMLLoader innerLoader = new FXMLLoader(getClass().getResource("views/LoginScreen.fxml"));
        ResourceBundle bundle = ResourceBundle.getBundle("lang");
        innerLoader.setResources(bundle);
        try {
            Stage stage = new Stage();
            Parent innerRoot = innerLoader.load();
            //TODO AS - SETTING ALL REQUIRED OBJECTS
            LoginScreenController controller = innerLoader.getController();
//            loginScreenController.setClient(client);

            stage.setTitle(ParameterProvider.WINDOW_TITLE);
            Scene scene = new Scene(innerRoot, 800, 500);
            stage.setScene(scene);
            stage.setMaximized(true);
            controller.setStage(stage);
            controller.setScene(scene);
            stage.show();

//            Platform.runLater(loginScreenController.thread::start);
//            loginScreenController.thread.start();

            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    System.out.println("Stage is closing");
//                    loginScreenController.checkConnection=Boolean.FALSE;
                }
            });

            primaryStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Main(String[] args) {
        launch(args);
    }
}
