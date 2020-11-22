package controls.releaseview;

import controls.dateview.DateView;
import controls.externaldateview.ExternalDateView;
import controls.releaseview.ReleaseUnit;
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

import java.io.IOException;

@AllArgsConstructor
public class ReleasePosition extends GridPane {

    @FXML
    @Getter
    @Setter
    private CheckBox checkBox;

    @FXML
    @Getter
    @Setter
    private Button number;

    @FXML
    @Getter
    @Setter
    private Button name;

    @FXML
    @Getter
    @Setter
    private ExternalDateView date;

    @FXML
    @Getter
    @Setter
    private Label focus;

    @Getter
    @Setter
    private Boolean clicked;

    @Getter
    private ReleaseUnit releaseUnit;

    public ReleasePosition() {
        this.clicked = Boolean.FALSE;


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ReleasePosition.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setReleaseUnit(ReleaseUnit releaseUnit) {
        this.releaseUnit = releaseUnit;

        checkBox.setSelected(releaseUnit.getSelect() != null ? releaseUnit.getSelect() : Boolean.FALSE);
        number.setText(releaseUnit.getNumber());
        name.setText(releaseUnit.getName());
        //TODO ADD NULLCHECK
//        startDate.setText(releaseUnit.getStartDate().toString());
//        endDate.setText(releaseUnit.getEndDate().toString());
//        company.setText(releaseUnit.getCompany());
        focus.setText(releaseUnit.getFocus());
        if(releaseUnit.getDate() != null){
            date.setValue(releaseUnit.getDate());
        }

    }

    public void setSelected() {
        releaseUnit.setSelect(checkBox.isSelected());
    }

    public void setClicked() {
        clicked = Boolean.TRUE;
    }

    public void setSelected(Boolean select) {
        checkBox.setSelected(select);
        releaseUnit.setSelect(select);
    }

    //TODO test
    public final void setOnAction(EventHandler<ActionEvent> value) {
        EventHandler<ActionEvent> current = name.getOnAction();
        name.setOnAction(e -> {
            current.handle(e);
            //TODO ADD NULLCHECK
            value.handle(e);
        });
        number.setOnAction(e -> {
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
            return ReleasePosition.this;//SwipeSelector.this;
        }

        @Override
        public String getName() {
            return "onAction";
        }
    };
}
