package controllers;

import controls.externaldateview.ExternalDateView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import lombok.Getter;

import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

public class TestScreenController implements Initializable {


    @FXML
    @Getter
    private GridPane pane;

    @FXML
    private ExternalDateView externalDateView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        externalDateView.setValue(new GregorianCalendar(2019, Calendar.SEPTEMBER, 10).getTime());
    }
}
