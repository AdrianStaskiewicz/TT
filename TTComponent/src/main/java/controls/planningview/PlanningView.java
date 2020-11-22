package controls.planningview;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import lombok.Getter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlanningView extends AnchorPane {

    @FXML
    private Label counter;//TODO change to button??

    @FXML
    private ScrollPane leftSide;
    @FXML
    private VBox leftPane;
    @FXML
    private ScrollPane rightSide;
    @FXML
    private VBox rightPane;

    private List<PlanningRelease> leftSidePlanningReleases;
    private List<PlanningRelease> rightSidePlanningReleases;

    private EventHandler<ActionEvent> releaseEvent;//TODO test
    private EventHandler<ActionEvent> positionEvent;//TODO test

    @Getter
    private Long releaseValue;
    @Getter
    private Long positionValue;

    public PlanningView() {
        this.leftSidePlanningReleases = new ArrayList<>();
        this.rightSidePlanningReleases = new ArrayList<>();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PlanningView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setLeftSideValue(PlanningViewUnit value) {
        PlanningRelease planningRelease = new PlanningRelease();
        planningRelease.setValue(value.getRelease());

        planningRelease.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (planningRelease.getUnit() != null) {
                    releaseValue = planningRelease.getUnit().getId();
                }
            }
        });
        planningRelease.setOnAction(releaseEvent);

        planningRelease.setOnPositionAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                positionValue = planningRelease.getPositionValue();
            }
        });

        planningRelease.setOnPositionAction(positionEvent);

        planningRelease.setPositions(value.getPositions());

        leftSidePlanningReleases.add(planningRelease);
        leftPane.getChildren().add(planningRelease);
    }

    public void setLeftSideValue(List<PlanningRelease> planningReleases) {

    }

    public void setRightSideValue(PlanningViewUnit value) {
        PlanningRelease planningRelease = new PlanningRelease();
        planningRelease.setValue(value.getRelease());

        planningRelease.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (planningRelease.getUnit() != null) {
                    releaseValue = planningRelease.getUnit().getId();
                }
            }
        });
        planningRelease.setOnAction(releaseEvent);

        planningRelease.setOnPositionAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                positionValue = planningRelease.getPositionValue();
            }
        });

        planningRelease.setOnPositionAction(positionEvent);//TODO AS1 problem fix a

        planningRelease.setPositions(value.getPositions());

        rightSidePlanningReleases.add(planningRelease);
        rightPane.getChildren().add(planningRelease);
    }

    public void setRightSideValue(List<PlanningRelease> planningReleases) {

    }

    public void removeAllLeftSideValues() {

    }

    public void removeAllRightSideValues() {

    }

    public Long getClickedRelease() {
//        for (PlanningPosition position : planningPositions) {
//            if (position.getIsClicked()) {
//                position.setIsClicked(Boolean.FALSE);
//                return position.getPlanningUnit();
//            }
//        }
//        return null;

        return releaseValue;
    }

    public Long getClickedPosition() {
//        for (PlanningPosition position : planningPositions) {
//            if (position.getIsClicked()) {
//                position.setIsClicked(Boolean.FALSE);
//                return position.getPlanningUnit();
//            }
//        }
//        return null;
        return 0L;
    }


    public Long getValue() {
//        for(PlanningRelease planningRelease : leftSidePlanningReleases){
//            if(planningRelease.getClickedPosition()!=null){
//                value = planningRelease.getClickedPosition().getId();
//            }
//        }
//
//        if(value!=null){
//            return value;
//        }else{
//            for(PlanningRelease planningRelease : rightSidePlanningReleases){
//                if(planningRelease.getClickedPosition()!=null){
//                    value = planningRelease.getClickedPosition().getId();
//                }
//            }
//        }
//
//        return this.value;

        return 12L;
    }

//    public void setValue(Long value) {
//        this.value = value;
//    }//


    //FOR RELEASE ACTION
    public final ObjectProperty<EventHandler<ActionEvent>> onReleaseActionProperty() {
        return onReleaseAction;
    }

    public final void setOnReleaseAction(EventHandler<ActionEvent> value) {
//        onActionProperty().set(value);
        releaseEvent = value;//TODO test
    }

    public final EventHandler<ActionEvent> getOnReleaseAction() {
        return onReleaseActionProperty().get();
    }

    private ObjectProperty<EventHandler<ActionEvent>> onReleaseAction = new ObjectPropertyBase<EventHandler<ActionEvent>>() {
        @Override
        protected void invalidated() {
            setEventHandler(ActionEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return PlanningView.this;
        }

        @Override
        public String getName() {
            return "onReleaseAction";
        }
    };

    //FOR POSITIONS ACTION
    public final ObjectProperty<EventHandler<ActionEvent>> onPositionActionProperty() {
        return onPositionAction;
    }

    public final void setOnPositionAction(EventHandler<ActionEvent> value) {
//        onActionProperty().set(value);
       positionEvent = value;//TODO test
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
            return PlanningView.this;//SwipeSelector.this;
        }

        @Override
        public String getName() {
            return "onPositionAction";
        }
    };

}
