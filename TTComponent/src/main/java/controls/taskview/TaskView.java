package controls.taskview;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskView extends AnchorPane {

    @FXML
    private GridPane taskPositionsPane;

    //    @FXML
    private List<TaskPosition> taskPositions;
//
//    private PlanningPosition planningPosition;

    private EventHandler<ActionEvent> testEvent;//TODO test

    public TaskView() {
        this.taskPositions = new ArrayList<>();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/TaskView.fxml"));
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
            return TaskView.this;//SwipeSelector.this;
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


    public TaskUnit getClickedPosition() {
        for (TaskPosition position : taskPositions) {
            if (position.getClicked()) {
                position.setClicked(Boolean.FALSE);
                return position.getTaskUnit();
            }
        }
        return null;
    }

    public void setValue(List<TaskUnit> taskUnits) {
        VBox vbox = new VBox();
        for (TaskUnit taskUnit : taskUnits) {
            TaskPosition taskPosition = new TaskPosition();

            taskPosition.setTaskUnit(taskUnit);
            taskPosition.setOnAction(testEvent);//TODO test

            taskPositions.add(taskPosition);

            vbox.getChildren().add(taskPosition);
        }

        taskPositionsPane.add(vbox, 0, 1);
    }
}
