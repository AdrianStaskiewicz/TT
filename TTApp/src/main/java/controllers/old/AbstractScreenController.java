package controllers.old;

import context.ContextHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Setter;

import java.net.URL;
import java.util.ResourceBundle;

//import enums.MessageType;

public class AbstractScreenController implements Initializable {

    @Setter
    @FXML
    protected static Stage stage;
    @Setter
    @FXML
    protected static Scene scene;

    @Setter
    protected ContextHandler contextHandler;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

//    public Boolean callPopup(MessageType messageType, String message) {
//        Parent root = null;
//
//        FXMLLoader innerLoader = new FXMLLoader();
//        innerLoader.setLocation(this.getClass().getResource("/controls/general/NewPopupScreen.fxml"));
//        ResourceBundle bundle = ResourceBundle.getBundle("lang");
//        innerLoader.setResources(bundle);
//
//        try {
//            root = innerLoader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        NewPopupScreenController popupScreenController;
//        popupScreenController = innerLoader.getController();
//
//        Scene popupScene = new Scene(root);
//        Stage newWindow = new Stage();
//
//        newWindow.initStyle(StageStyle.UNDECORATED);
//        newWindow.initStyle(StageStyle.TRANSPARENT);
//        popupScene.setFill(Color.TRANSPARENT);
//
////       this.stage.getScene();
//        newWindow.initOwner(scene.getWindow());
//        newWindow.initModality(Modality.WINDOW_MODAL);
//        newWindow.setScene(popupScene);
//        newWindow.setResizable(false);
//
//        popupScreenController.setScene(popupScene);
//        popupScreenController.setStage(newWindow);
//
//        popupScreenController.setMessage(message);
//
//        switch (messageType) {
//            case ERROR:
//                popupScreenController.setImage("icons/error_symbol_icon.png");
//                popupScreenController.disableSecondButton();
//                break;
//            case WARNING:
//                popupScreenController.setImage("icons/warning_symbol_icon.png");
////                popupScreenController.disableSecondButton();
//                break;
//            case CONFIRMATION:
//                popupScreenController.setImage("icons/confirmation_symbol_icon.png");
//                popupScreenController.disableSecondButton();
//                break;
//            case QUESTION:
//                popupScreenController.setImage("icons/error_symbol_icon.png");
//                break;
//        }
//
//        newWindow.showAndWait();
//
//        return popupScreenController.getAnswer();
//    }

    protected void goToLoginScreen() {
//        FXMLLoader innerLoader = new FXMLLoader();
//        innerLoader.setLocation(this.getClass().getResource("/controls/general/LoginScreen.fxml"));
//        ResourceBundle bundle = ResourceBundle.getBundle("lang");
//        innerLoader.setResources(bundle);
//
//        try {
////            stage
//
//            Parent innerRoot = innerLoader.load();
//            LoginScreenControllerController loginScreenController = innerLoader.getController();
////            mainScreenController.setClient(client);
////            mainScreenController.setLocalDatabase(localDatabase);
////            stage.setTitle("PasswordsManager 1.0.0");
////            Scene scene = new Scene()
//            scene.setRoot(innerRoot);
//            stage.setScene(scene);
//            stage.setMaximized(true);
//            loginScreenController.setScene(scene);
//            loginScreenController.setStage(stage);
//            stage.show();
////            primaryStage.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

//    protected void goToLoginScreen(MessageType messageType, String message) {
//        FXMLLoader innerLoader = new FXMLLoader();
//        innerLoader.setLocation(this.getClass().getResource("/controls/general/LoginScreen.fxml"));
//        ResourceBundle bundle = ResourceBundle.getBundle("lang");
//        innerLoader.setResources(bundle);
//
//        try {
//
//            Parent innerRoot = innerLoader.load();
//            LoginScreenControllerController loginScreenController = innerLoader.getController();
//
//            scene.setRoot(innerRoot);
//            stage.setScene(scene);
//            stage.setMaximized(true);
//            loginScreenController.setScene(scene);
//            loginScreenController.setStage(stage);
//            stage.show();
//            if (messageType != null && message != null) {
//                loginScreenController.callPopup(messageType, message);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    protected void goToFarmCreationPage() {
//        FXMLLoader innerLoader = new FXMLLoader();
//        innerLoader.setLocation(this.getClass().getResource("/controls/general/FarmAddEditScreen.fxml"));
//        ResourceBundle bundle = ResourceBundle.getBundle("lang");
//        innerLoader.setResources(bundle);
//
//        try {
//            Parent innerRoot = innerLoader.load();
//            FarmAddEditScreenControllerController controller = innerLoader.getController();
//
//            scene.setRoot(innerRoot);
//            stage.setScene(scene);
//            stage.setMaximized(true);
//            controller.setScene(scene);
//            controller.setStage(stage);
//            controller.setContextHandler(this.contextHandler);
//            stage.show();
//
//            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//                public void handle(WindowEvent we) {
//                    System.out.println("Stage is closing");
//                }
//            });
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
