package controls;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlanningView extends AnchorPane {

    @FXML
    private Label title;//TODO change to button
    @FXML
    private Button checkAll;
    @FXML
    private Button uncheckAll;
    @FXML
    private GridPane planningPositionsPane;

    //    @FXML
    private List<PlanningPosition> planningPositions;
//
//    private PlanningPosition planningPosition;

    private EventHandler<ActionEvent> testEvent;//TODO test

    public PlanningView() {
        this.planningPositions = new ArrayList<>();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/PlanningView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty() {
        return onAction;
    }

    public final void setOnAction(EventHandler<ActionEvent> value) {
//        onActionProperty().set(value);
        testEvent = value;//TODO test
    }

    public final EventHandler<ActionEvent> getOnAction() {
        return onActionProperty().get();
    }

    private ObjectProperty<EventHandler<ActionEvent>> onAction = new ObjectPropertyBase<EventHandler<ActionEvent>>() {
        @Override
        protected void invalidated() {
            setEventHandler(ActionEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return PlanningView.this;//SwipeSelector.this;
        }

        @Override
        public String getName() {
            return "onAction";
        }
    };

//    public String getText() {
//        return textProperty().get();
//    }
//
//    public void setText(String value) {
//        textProperty().set(value);
//    }

//    public StringProperty textProperty() {
//        return textField.textProperty();
//    }

//    @FXML
//    protected void doSomething() {
//        value = String.valueOf(textField.getText().length());
//        System.out.println("The button was clicked!");
//    }


    public PlanningUnit getClickedPosition() {
        for (PlanningPosition position : planningPositions) {
            if (position.getClicked()) {
                position.setClicked(Boolean.FALSE);
                return position.getPlanningUnit();
            }
        }
        return null;
    }

    public void setValue(List<PlanningUnit> planningUnits) {
        VBox vbox = new VBox();
        for (PlanningUnit planningUnit : planningUnits) {
            PlanningPosition planningPosition = new PlanningPosition();

            planningPosition.setPlanningUnit(planningUnit);
            planningPosition.setOnAction(testEvent);//TODO test

            planningPositions.add(planningPosition);

            vbox.getChildren().add(planningPosition);
        }

        planningPositionsPane.add(vbox, 0, 1);
    }

    @FXML
    protected void checkAll() {
        for (PlanningPosition position : planningPositions) {
            position.setSelected(Boolean.TRUE);
        }
    }

    @FXML
    protected void uncheckAll() {
        for (PlanningPosition position : planningPositions) {
            position.setSelected(Boolean.FALSE);
        }
    }
}
