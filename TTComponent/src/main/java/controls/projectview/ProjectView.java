package controls.projectview;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectView extends AnchorPane {

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
    private VBox projectPane;

    //    @FXML
    private List<ProjectPosition> projectPositions;
//
//    private PlanningPosition planningPosition;

    private EventHandler<ActionEvent> testEvent;//TODO test

    public ProjectView() {
        this.projectPositions = new ArrayList<>();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ProjectView.fxml"));
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
            return ProjectView.this;//SwipeSelector.this;
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
            return ProjectView.this;//SwipeSelector.this;
        }

        @Override
        public String getName() {
            return "onAdd";
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


    public ProjectUnit getClickedPosition() {
        for (ProjectPosition position : projectPositions) {
            if (position.getClicked()) {
                position.setClicked(Boolean.FALSE);
                return position.getProjectUnit();
            }
        }
        return null;
    }

    public void setValue(List<ProjectUnit> projectUnits) {
        projectPane.getChildren().clear();
        projectPositions = new ArrayList<>();

        for (ProjectUnit projectUnit : projectUnits) {
            ProjectPosition projectPosition = new ProjectPosition();

            projectPosition.setProjectUnit(projectUnit);
            projectPosition.setOnAction(testEvent);//TODO test

            projectPositions.add(projectPosition);

            projectPane.getChildren().add(projectPosition);
        }

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

        for (ProjectPosition position : projectPositions) {
            position.setSelected(Boolean.TRUE);
        }
    }

    @FXML
    protected void uncheckAll() {
        checkAll.setDisable(Boolean.FALSE);
        edit.setDisable(Boolean.TRUE);
        delete.setDisable(Boolean.TRUE);

        for (ProjectPosition position : projectPositions) {
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
