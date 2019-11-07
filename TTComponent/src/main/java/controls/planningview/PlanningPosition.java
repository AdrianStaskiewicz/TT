package controls.planningview;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@AllArgsConstructor
public class PlanningPosition extends GridPane {
    @FXML
    @Getter
    @Setter
    private GridPane base;

    @FXML
    @Getter
    @Setter
    private CheckBox checkBox;

    @FXML
    @Getter
    @Setter
    private Button title;

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
    private PlanningUnit planningUnit;

    public PlanningPosition() {
        this.clicked = Boolean.FALSE;


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PlanningPosition.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setPlanningUnit(PlanningUnit planningUnit){
        this.planningUnit = planningUnit;

        checkBox.setSelected(planningUnit.getSelect()!=null? planningUnit.getSelect():Boolean.FALSE);
        title.setText(planningUnit.getTitle());
        person.setText(planningUnit.getPerson());
        progress.progressProperty().setValue(planningUnit.getProgress());
    }

    public void setSelected(){
        planningUnit.setSelect(checkBox.isSelected());
    }

    public void setClicked() {
        clicked = Boolean.TRUE;
    }

    public void setSelected(Boolean select) {
        checkBox.setSelected(select);
        planningUnit.setSelect(select);
    }

    //TODO test
    public final void setOnAction(EventHandler<ActionEvent> value) {
        EventHandler<ActionEvent> current = title.getOnAction();
        title.setOnAction(e -> {
            current.handle(e);
            //TODO ADD NULLCHECK
            if(value!=null){
                value.handle(e);
            }
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
            return PlanningPosition.this;//SwipeSelector.this;
        }

        @Override
        public String getName() {
            return "onAction";
        }
    };
}
