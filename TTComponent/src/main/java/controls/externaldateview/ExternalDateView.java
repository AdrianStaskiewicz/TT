package controls.externaldateview;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import utils.DateUtil;

import java.io.IOException;
import java.util.Date;

public class ExternalDateView extends GridPane {

    @FXML
    private GridPane durationPane;
    @FXML
    private GridPane datePane;
    @FXML
    private Label duration;
    @FXML
    private Label date;

    public ExternalDateView() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ExternalDateView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setValue(Date value) {
        String dateLabelStyle = "-fx-text-fill:white; -fx-font-weight: bold";
        String durationLabelStyle = "-fx-text-fill:black; -fx-font-weight: bold";
        String datePaneStyle = "-fx-border-radius: 5 5 5 5;-fx-border-color: #828588;-fx-background-radius: 5 5 5 5;-fx-background-color: #828588;";
        String durationBeforePaneStyle = "-fx-border-radius: 5 5 5 5;-fx-border-color: #E2FCE9;-fx-background-radius: 5 5 5 5;-fx-background-color: #E2FCE9;";
        String durationAfterPaneStyle = "-fx-border-radius: 5 5 5 5;-fx-border-color: #FDCACA;-fx-background-radius: 5 5 5 5;-fx-background-color: #FDCACA;";


        Date currentDate = new Date();
        Long difference = currentDate.getTime() - value.getTime();
        Long differenceMonth = difference / (24 * 60 * 60 * 1000) / 30;
        Long differenceWeek = difference / (7 * 24 * 60 * 60 * 1000);
        Long differenceDay = difference / (24 * 60 * 60 * 1000);

        date.setText(DateUtil.toSimpleDate(value));
        date.setStyle(dateLabelStyle);
        datePane.setStyle(datePaneStyle);
        duration.setStyle(durationLabelStyle);

        if (differenceDay > 0) {
            durationPane.setStyle(durationAfterPaneStyle);
            if (differenceMonth > 1) {
                duration.setText(differenceMonth + " months late");
            } else if (differenceWeek > 1) {
                duration.setText(differenceWeek + " weeks late");
            } else {
                duration.setText(differenceDay + " days late");
            }
        } else {
            durationPane.setStyle(durationBeforePaneStyle);
            if(differenceDay == 0){
                duration.setText("Today");
            }else{
                if (differenceMonth < -1) {
                    duration.setText("In " + differenceMonth * -1 + " months");
                } else if (differenceWeek < -1) {
                    duration.setText("In " + differenceWeek * -1 + " weeks");
                } else {
                    duration.setText("In " + differenceDay * -1 + " days");
                }
            }

        }
    }
}
