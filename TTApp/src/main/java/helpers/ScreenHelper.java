package helpers;

import context.ContextHandler;
import controllers.AbstractSubScreenController;
import controllers.LoginScreenController;
import controllers.MainScreenController;
import controllers.TaskDetailSubScreenController;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import parameters.ParameterProvider;

import java.io.IOException;
import java.util.ResourceBundle;

public class ScreenHelper<T extends AbstractSubScreenController> {
    //base window configuration
    private Stage stage;
    private Scene scene;

    //subscreen configuration
    private MainScreenController mainScreenController;
    private StackPane stackPane;


    public ScreenHelper() {
        this.stage = new Stage();
        this.stage.setTitle(ParameterProvider.WINDOW_TITLE);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing");
            }
        });
    }

    public ScreenHelper(Stage stage, Scene scene) {
        this.stage = stage;
        this.scene = scene;
    }

    public void configure(Stage stage, Scene scene) {
        this.stage = stage;
        this.scene = scene;
    }

    public void configure(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }

    public void configure(StackPane stackPane) {
        this.stackPane = stackPane;
    }

    public void goToLoginScreen(Stage primaryStage) {
        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource("/views/LoginScreen.fxml"));

        ResourceBundle bundle = ResourceBundle.getBundle("lang");
        innerLoader.setResources(bundle);
        try {
            Parent innerRoot = innerLoader.load();
            LoginScreenController controller = innerLoader.getController();

            scene.setRoot(innerRoot);
            stage.setScene(scene);
            stage.setMaximized(true);

            controller.setStage(stage);
            controller.setScene(scene);

            stage.show();

            primaryStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToMainScreen(ContextHandler contextHandler, ScreenHelper screenHelper) {
        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource("/views/MainScreen.fxml"));

        try {
            Parent innerRoot = innerLoader.load();
            MainScreenController controller = innerLoader.getController();

            scene.setRoot(innerRoot);
//            stage.setScene(scene);
//            stage.setMaximized(true);

            controller.setContextHandler(contextHandler);
            controller.setScreenHelper(screenHelper);
            controller.initializeData();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToSubScreen(String path) {
        mainScreenController.enableAllButtons();

        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource(path));

        GridPane gridPane = null;
        try {
            gridPane = innerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        T controller = innerLoader.getController();
        mainScreenController.getContextHandler().setCurrentScreenController(controller);
        controller.setMainScreenController(mainScreenController);
        controller.initializeData();

        setView(gridPane);
    }

    public void goToTaskDetailSubScreenWithDataInitialization(Long taskId) {
        mainScreenController.enableAllButtons();

        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource("/views/TaskDetailSubScreen2.fxml"));

        GridPane gridPane = null;
        try {
            gridPane = innerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TaskDetailSubScreenController controller = innerLoader.getController();
        mainScreenController.getContextHandler().setCurrentScreenController(controller);
        controller.setMainScreenController(mainScreenController);
        controller.initializeData();

        setView(gridPane);
    }

    private void setView(GridPane gridPane) {
        stackPane.getChildren().clear();
        stackPane.getChildren().add(gridPane);
    }

}
