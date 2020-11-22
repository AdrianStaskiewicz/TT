package controllers;

import javafx.fxml.Initializable;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.ResourceBundle;

public class AbstractSubScreenController implements Initializable {

    @Getter
    @Setter
    private MainScreenController mainScreenController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void initializeData() {
    }
    public void refreshData(){

    }
}
