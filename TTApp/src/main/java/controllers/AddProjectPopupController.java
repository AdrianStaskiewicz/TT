package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lombok.Setter;

import java.net.URL;
import java.util.ResourceBundle;

public class AddProjectPopupController implements Initializable {
    @FXML
    @Setter
    private Stage stage;

    @FXML
    private Button closePopup;
    @FXML
    private Button addProject;
    @FXML
    private GridPane topBar;

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    public void closePopup(){
        Stage stage2 = (Stage) closePopup.getScene().getWindow();
        stage2.close();
    }

    @FXML
    public void addProject(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        topBar.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        topBar.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
    }
}
