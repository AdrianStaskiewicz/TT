package controls.projectview;

import controls.dateview.DateView;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import utils.DateUtil;

import java.io.IOException;

@AllArgsConstructor
public class ProjectPosition extends GridPane {

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
    private DateView startDate;

    @FXML
    @Getter
    @Setter
    private DateView endDate;

    @FXML
    @Getter
    @Setter
    private Label company;

    @FXML
    @Getter
    @Setter
    private Label description;

    @Getter
    @Setter
    private Boolean clicked;

    @Getter
    private ProjectUnit projectUnit;

    public ProjectPosition() {
        this.clicked = Boolean.FALSE;


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ProjectPosition.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setProjectUnit(ProjectUnit projectUnit) {
        this.projectUnit = projectUnit;

        checkBox.setSelected(projectUnit.getSelect() != null ? projectUnit.getSelect() : Boolean.FALSE);
        title.setText(projectUnit.getTitle());
        //TODO ADD NULLCHECK
//        startDate.setText(projectUnit.getStartDate().toString());
//        endDate.setText(projectUnit.getEndDate().toString());
        company.setText(projectUnit.getCompany());
        description.setText(projectUnit.getDescription());
        if(projectUnit.getStartDate() != null){
            startDate.setValue(projectUnit.getStartDate());
        }
        if(projectUnit.getEndDate() != null){
            endDate.setValue(projectUnit.getEndDate());
        }

    }

    public void setSelected() {
        projectUnit.setSelect(checkBox.isSelected());
    }

    public void setClicked() {
        clicked = Boolean.TRUE;
    }

    public void setSelected(Boolean select) {
        checkBox.setSelected(select);
        projectUnit.setSelect(select);
    }

    //TODO test
    public final void setOnAction(EventHandler<ActionEvent> value) {
        EventHandler<ActionEvent> current = title.getOnAction();
        title.setOnAction(e -> {
            current.handle(e);
            //TODO ADD NULLCHECK
            value.handle(e);
        });
    }

    //TODO test
    public final void setOnSelect(EventHandler<ActionEvent> value) {
        EventHandler<ActionEvent> current = checkBox.getOnAction();
        checkBox.setOnAction(e -> {
            current.handle(e);
            //TODO ADD NULLCHECK
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
            return ProjectPosition.this;//SwipeSelector.this;
        }

        @Override
        public String getName() {
            return "onAction";
        }
    };
}
