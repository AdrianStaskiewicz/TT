package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.ResourceBundle;

public class WorkItemSubScreenController extends AbstractSubScreenController {

    @Getter
    @Setter
    private MainScreenController mainScreenController;

    @FXML
    public void createTask(){
        mainScreenController.enableAllButtons();
    }

    @FXML
    public void resetFilters(){

    }
    @FXML
    public void applyFilters(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
