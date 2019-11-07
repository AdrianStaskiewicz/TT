package controls.dateview;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import utils.DateUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class DateView extends GridPane {

    @FXML
    private GridPane pane;
    @FXML
    private Label date;

    public DateView(){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/DateView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setValue(Date value){
        date.setText(DateUtil.toSimpleDate(value));

        String labelStyle = "-fx-text-fill:white; -fx-font-weight: bold";
        String paneStyle = "-fx-border-radius: 5 5 5 5;-fx-border-color: #828588;-fx-background-radius: 5 5 5 5;-fx-background-color: #828588;";

        date.setStyle(labelStyle);
        pane.setStyle(paneStyle);
    }
}
