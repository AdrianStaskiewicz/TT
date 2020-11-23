package controls.releaseview;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReleaseView extends AnchorPane {

    @FXML
    private Button add;
    @FXML
    private Button save;
    @FXML
    private Button cancel;
    @FXML
    private Button checkAll;
    @FXML
    private Button uncheckAll;
    @FXML
    private Button edit;
    @FXML
    private Button delete;
    @FXML
    private VBox releasePane;

    //    @FXML
    private List<ReleasePosition> releasePositions;
//
//    private PlanningPosition planningPosition;

    private EventHandler<ActionEvent> testEvent;//TODO test

    public ReleaseView() {
        this.releasePositions = new ArrayList<>();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ReleaseView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }


        Label emptyListNotification = new Label("No releases found");
        emptyListNotification.setStyle("-fx-text-fill: rgb(110,110,110)");
        emptyListNotification.setPadding(new Insets(10));
        releasePane.getChildren().add(emptyListNotification);
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
            return ReleaseView.this;//SwipeSelector.this;
        }

        @Override
        public String getName() {
            return "onAction";
        }
    };


    public final ObjectProperty<EventHandler<ActionEvent>> onAddProperty() {
        return onAdd;
    }

    public final void setOnAdd(EventHandler<ActionEvent> value) {
//        onActionProperty().set(value);
//        testEvent = value;//TODO test
//        System.out.println("LOl");
        add.setOnAction(value);
    }

    public final EventHandler<ActionEvent> getOnAdd() {
        return onAddProperty().get();
    }

    private ObjectProperty<EventHandler<ActionEvent>> onAdd = new ObjectPropertyBase<EventHandler<ActionEvent>>() {
        @Override
        protected void invalidated() {
            setEventHandler(ActionEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return ReleaseView.this;//SwipeSelector.this;
        }

        @Override
        public String getName() {
            return "onAdd";
        }
    };

    public final ObjectProperty<EventHandler<ActionEvent>> onDeleteProperty() {
        return onDelete;
    }

    public final void setOnDelete(EventHandler<ActionEvent> value) {
//        onActionProperty().set(value);
//        testEvent = value;//TODO test
//        System.out.println("LOl");
        delete.setOnAction(value);
    }

    public final EventHandler<ActionEvent> getOnDelete() {
        return onDeleteProperty().get();
    }

    private ObjectProperty<EventHandler<ActionEvent>> onDelete = new ObjectPropertyBase<EventHandler<ActionEvent>>() {
        @Override
        protected void invalidated() {
            setEventHandler(ActionEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return ReleaseView.this;//SwipeSelector.this;
        }

        @Override
        public String getName() {
            return "onDelete";
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


    public ReleaseUnit getClickedPosition() {
        for (ReleasePosition position : releasePositions) {
            if (position.getClicked()) {
                position.setClicked(Boolean.FALSE);
                return position.getReleaseUnit();
            }
        }
        return null;
    }

    public List<ReleaseUnit> getSelectedPositions() {
        List<ReleaseUnit> result = new ArrayList<>();
        for (ReleasePosition position : releasePositions) {
            if (position.getCheckBox().isSelected()) {
                result.add(position.getReleaseUnit());
            }
        }
        return result;
    }

    public void setValue(List<ReleaseUnit> releaseUnits) {
//        if(releaseUnits.size()>0){
            releasePane.getChildren().clear();
            releasePositions = new ArrayList<>();

            for (ReleaseUnit releaseUnit : releaseUnits) {
                ReleasePosition releasePosition = new ReleasePosition();

                releasePosition.setReleaseUnit(releaseUnit);
                releasePosition.setOnAction(testEvent);//TODO test
                releasePosition.setOnSelect(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        delete.setDisable(Boolean.FALSE);
                        System.out.println("Test ReleaseView: " + releasePosition);
                    }
                });

                releasePositions.add(releasePosition);

                releasePane.getChildren().add(releasePosition);
            }

//        }

    }

    @FXML
    protected void add() {

    }

    @FXML
    protected void save() {
        uncheckAll();

        save.setDisable(Boolean.TRUE);
        cancel.setDisable(Boolean.TRUE);
        uncheckAll.setDisable(Boolean.FALSE);
    }

    @FXML
    protected void checkAll() {
        edit.setDisable(Boolean.FALSE);
        delete.setDisable(Boolean.FALSE);

        for (ReleasePosition position : releasePositions) {
            position.setSelected(Boolean.TRUE);
        }
    }

    @FXML
    protected void uncheckAll() {
        checkAll.setDisable(Boolean.FALSE);
        edit.setDisable(Boolean.TRUE);
        delete.setDisable(Boolean.TRUE);

        for (ReleasePosition position : releasePositions) {
            position.setSelected(Boolean.FALSE);
        }
    }

    @FXML
    protected void cancel() {
        uncheckAll();

        save.setDisable(Boolean.TRUE);
        cancel.setDisable(Boolean.TRUE);
        uncheckAll.setDisable(Boolean.FALSE);
    }

    @FXML
    protected void edit() {
        save.setDisable(Boolean.FALSE);
        cancel.setDisable(Boolean.FALSE);
        checkAll.setDisable(Boolean.TRUE);
        uncheckAll.setDisable(Boolean.TRUE);
    }

    @FXML
    protected void delete() {
        uncheckAll();

        save.setDisable(Boolean.TRUE);
        cancel.setDisable(Boolean.TRUE);
        uncheckAll.setDisable(Boolean.FALSE);
    }
}
