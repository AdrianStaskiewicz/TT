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
//    @FXML
//    @Getter
//    @Setter
//    private GridPane base;

    @FXML
    @Getter
    @Setter
    private CheckBox selector;
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
    //TODO add other controls here (time ratio and priority)

    @Getter
    private PlanningViewPositionUnit unit;

    @Getter
    @Setter
    private Boolean isSelected;
    @Getter
    @Setter
    private Boolean isClicked;

    public PlanningPosition() {
        this.isSelected = Boolean.FALSE;
        this.isClicked = Boolean.FALSE;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PlanningPosition.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


    public void setValue(PlanningViewPositionUnit value) {
        this.unit = value;
        this.isSelected = unit.getIsSelected() != null ? unit.getIsSelected() : Boolean.FALSE;

        selector.setSelected(unit.getIsSelected() != null ? unit.getIsSelected() : Boolean.FALSE);
        title.setText(unit.getTitle());
        person.setText(unit.getPerson());
        progress.progressProperty().setValue(unit.getProgress());
        //TODO set other controls here (time ratio and priority)
    }

    public PlanningViewPositionUnit getValue() {
        return this.unit;
    }


    public void select() {
        isSelected = Boolean.TRUE;
        selector.setSelected(Boolean.TRUE);
    }

    public void unselect() {
        isSelected = Boolean.FALSE;
        selector.setSelected(Boolean.FALSE);
    }

    public void click() {
        isClicked = Boolean.TRUE;
        System.out.println("Test: " + unit.getId());
    }

    public void unclick() {
        isClicked = Boolean.FALSE;
    }

    @FXML
    public void onSelectorAction() {
        isSelected = selector.isSelected();
    }


    //    DEFAULT PART - DO NOT CHANGE
    public final void setOnAction(EventHandler<ActionEvent> value) {
        EventHandler<ActionEvent> current = title.getOnAction();
        title.setOnAction(e -> {
            if (current != null) {
                current.handle(e);
            }

            if (value != null) {
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
            return PlanningPosition.this;
        }

        @Override
        public String getName() {
            return "onAction";
        }
    };
}
