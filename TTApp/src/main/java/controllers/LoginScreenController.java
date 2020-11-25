package controllers;

import context.ContextHandler;
import helpers.ScreenHelper;
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

    @Setter
    protected ScreenHelper screenHelper;

    private AuthenticationRequest authenticationRequest;
    private UserRequest userRequest;
    private ProjectRequest projectRequest;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.screenHelper = new ScreenHelper(stage,scene);

        this.authenticationRequest = new AuthenticationRequest();
        this.userRequest = new UserRequest();
        this.projectRequest = new ProjectRequest();
    }

    @FXML
    public void login() {
        Long userId = authenticationRequest.login(username.getText(), password.getText());
        if (userId != null) {
            ScreenHelper screenHelper = new ScreenHelper();
            ContextHandler contextHandler = new ContextHandler();
            contextHandler.setCurrentUser(userRequest.findById(userId));
            screenHelper.configure(stage, scene);
            screenHelper.goToMainScreen(contextHandler, screenHelper);
        }

    }

    @FXML
    public void forgetPassword() {
    }

}
