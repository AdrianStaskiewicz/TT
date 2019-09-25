package controls;

import controls.TaskView.TaskUnit;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@AllArgsConstructor
public class TaskPosition extends GridPane {
    @FXML
    @Getter
    @Setter
    private GridPane base;

    @FXML
    @Getter
    @Setter
    private Button description;

    @FXML
    @Getter
    @Setter
    private Label person;

    @FXML
    @Getter
    @Setter
    private ProgressBar progress;

    @Getter
    @Setter
    private Boolean clicked;

    @Getter
    private TaskUnit taskUnit;

    public TaskPosition() {
        this.clicked = Boolean.FALSE;


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controls/TaskView/TaskPosition.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setTaskUnit(TaskUnit taskUnit){
        this.taskUnit = taskUnit;

        description.setText(taskUnit.getDescription());
        person.setText(taskUnit.getPerson());
        progress.progressProperty().setValue(taskUnit.getProgress());
    }

//    public void setSelected(){
//        taskUnit.setSelect(checkBox.isSelected());
//    }

    public void setClicked() {
        clicked = Boolean.TRUE;
    }

//    public void setSelected(Boolean select) {
//        checkBox.setSelected(select);
//        planningUnit.setSelect(select);
//    }

    //TODO test
    public final void setOnAction(EventHandler<ActionEvent> value) {
        EventHandler<ActionEvent> current = description.getOnAction();
        description.setOnAction(e -> {
            current.handle(e);
            //TODO NULLCHECK
            value.handle(e);
        });
    }


    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty() {
        return onAction;
    }

    private ObjectProperty<EventHandler<ActionEvent>> onAction = new ObjectPropertyBase<EventHandler<ActionEvent>>() {
        @Override
        protected void invalidated() {
            setEventHandler(ActionEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return TaskPosition.this;//SwipeSelector.this;
        }

        @Override
        public String getName() {
            return "onAction";
        }
    };
}
