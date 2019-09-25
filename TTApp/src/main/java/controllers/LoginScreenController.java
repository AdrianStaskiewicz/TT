package controllers;

import context.ContextHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import requests.AuthenticationRequest;
import requests.UserRequest;
import requests.ProjectRequest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginScreenController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @Getter
    @Setter
    private Stage stage;
    @Getter
    @Setter
    private Scene scene;

    private AuthenticationRequest authenticationRequest;
    private UserRequest userRequest;
    private ProjectRequest projectRequest;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.authenticationRequest = new AuthenticationRequest();
        this.userRequest = new UserRequest();
        this.projectRequest = new ProjectRequest();
    }

    @FXML
    public void login() {
//TODO uncomment all
        Long userId = authenticationRequest.login(username.getText(), password.getText());
        if(userId!=null){
        ContextHandler contextHandler = new ContextHandler();
            contextHandler.setCurrentUser(userRequest.findById(userId));
        gotoMainScreen(contextHandler);
        }

    }

    @FXML
    public void forgetPassword() {
    }


    private void gotoMainScreen(ContextHandler contextHandler) {
        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource("/views/MainScreen.fxml"));

        try {
            Parent innerRoot = innerLoader.load();
            MainScreenController controller = innerLoader.getController();

            scene.setRoot(innerRoot);
            stage.setScene(scene);
            stage.setMaximized(true);
            controller.setContextHandler(contextHandler);
            controller.initializeData();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
