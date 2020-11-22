package controls.planningview;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlanningRelease extends AnchorPane {

    @FXML
    @Getter
    @Setter
    private Button title;
    @FXML
    @Getter
    @Setter
    private Button checkAll;
    @FXML
    @Getter
    @Setter
    private Button uncheckAll;
    //TODO ad other controls here (release date, spend andd estimated time)
    @FXML
    @Getter
    @Setter
    private GridPane planningPositionsPane;

    private List<PlanningPosition> planningPositions;

    @Getter
    @Setter
    private PlanningViewReleaseUnit unit;

    @Getter
    @Setter
    private Boolean isClicked;
    @Getter
    @Setter
    private Boolean isPositionClicked;//TODO is it needed?

    @Getter
    private Long positionValue;

    //    private EventHandler<ActionEvent> testEvent;//TODO test
    private EventHandler<ActionEvent> positionEvent;//TODO test

    private List<EventHandler<ActionEvent>> test;//TODO test

    public PlanningRelease() {
        this.isClicked = Boolean.FALSE;
        this.isPositionClicked = Boolean.FALSE;

        this.planningPositions = new ArrayList<>();

        test = new ArrayList<>();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PlanningRelease.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setValue(PlanningViewReleaseUnit value) {
        this.unit = value;

        title.setText(unit.getTitle());
        //TODO add other controls here (release date, spend and estimated time)
    }

    public PlanningViewReleaseUnit getValue() {
        return this.unit;
    }


    public void click() {
        isClicked = Boolean.TRUE;
    }

    public void unclick() {
        isClicked = Boolean.FALSE;
    }

//    public PlanningUnit getClickedPosition() {
//        for (PlanningPosition position : planningPositions) {
//            if (position.getIsClicked()) {
//                position.setIsClicked(Boolean.FALSE);
//                return position.getPlanningUnit();
//            }
//        }
//        return null;
//    }

    public void setPositions(List<PlanningViewPositionUnit> positions) {
        VBox vbox = new VBox();

        for (PlanningViewPositionUnit position : positions) {
            PlanningPosition planningPosition = new PlanningPosition();

            planningPosition.setValue(position);
            //TODO add more event here
            planningPosition.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    if (planningPosition.getUnit() != null) {
                        positionValue = planningPosition.getUnit().getId();
                    }
                    System.out.println("Test: " + positionValue);
                }
            });

            planningPosition.setOnAction(positionEvent);

            if(test.size()>0){
                planningPosition.setOnAction(test.get(0));//TODO test
            }


            planningPositions.add(planningPosition);

            vbox.getChildren().add(planningPosition);
        }

        planningPositionsPane.add(vbox, 0, 1);
    }

    @FXML
    protected void checkAll() {
        for (PlanningPosition position : planningPositions) {
            position.select();
        }
    }

    @FXML
    protected void uncheckAll() {
        for (PlanningPosition position : planningPositions) {
            position.unselect();
        }
    }

    //    DEFAULT PART - DO NOT CHANGE
    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty() {
        return onAction;
    }

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
            return PlanningRelease.this;//SwipeSelector.this;
        }

        @Override
        public String getName() {
            return "onAction";
        }
    };

    //FOR POSITIONS ACTION
    public final ObjectProperty<EventHandler<ActionEvent>> onPositionActionProperty() {
        return onPositionAction;
    }

    public final void setOnPositionAction(EventHandler<ActionEvent> value) {
//        onActionProperty().set(value);
//TODO handle more than one event

        if (positionEvent != null) {
            System.out.println("Mam cos w evencie");
            test.add(value);
        } else {
            positionEvent = value;//TODO test
        }

    }

    public final EventHandler<ActionEvent> getOnPositionAction() {
        return onPositionActionProperty().get();
    }

    private ObjectProperty<EventHandler<ActionEvent>> onPositionAction = new ObjectPropertyBase<EventHandler<ActionEvent>>() {
        @Override
        protected void invalidated() {
            setEventHandler(ActionEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return PlanningRelease.this;//SwipeSelector.this;
        }

        @Override
        public String getName() {
            return "onPositionAction";
        }
    };
}
