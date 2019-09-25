package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateTaskSubScreenController implements Initializable {

    @Getter
    @Setter
    private MainScreenController mainScreenController;


    @FXML
    public void createTask(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
