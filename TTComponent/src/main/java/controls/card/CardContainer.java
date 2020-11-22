package controls.card;

import controls.projectview.ProjectPosition;
import controls.projectview.ProjectUnit;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CardContainer<T extends Card> extends AnchorPane {

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
    private VBox cardPane;

    private EventHandler<ActionEvent> onActionEvent;
    private EventHandler<ActionEvent> onAddEvent;
    private EventHandler<ActionEvent> onSaveEvent;
    private EventHandler<ActionEvent> onDeleteEvent;
//
//    private List<T> cards;
//    private EventHandler<ActionEvent> testEvent;//TODO test??

    private ObjectProperty<ObservableList<T>> items = new SimpleObjectProperty<ObservableList<T>>(this, "items");
    public final void setItems(ObservableList<T> value) { itemsProperty().set(value); }//TODO add extra actions
    public final ObservableList<T> getItems() {return items.get(); }
    public ObjectProperty<ObservableList<T>> itemsProperty() { return items; }

    public CardContainer() {
        initialize();
    }

    public CardContainer(ObservableList<T> items) {
        initialize();
        setItems(items);
//        setSelectionModel(new ComboBox.ComboBoxSelectionModel<T>(this));

    }

    private void initialize() {
        this.items = new SimpleObjectProperty<ObservableList<T>>(this, "items");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/CardContainer.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty() { return onAction; }
    public final void setOnAction(EventHandler<ActionEvent> value) { onActionEvent = value; }
    public final EventHandler<ActionEvent> getOnAction() { return onActionProperty().get(); }
    private ObjectProperty<EventHandler<ActionEvent>> onAction = new ObjectPropertyBase<>() {
        @Override protected void invalidated() { setEventHandler(ActionEvent.ACTION, get()); }
        @Override public Object getBean() { return CardContainer.this; }
        @Override public String getName() { return "onAction"; }
    };

    public final ObjectProperty<EventHandler<ActionEvent>> onAddProperty() { return onAdd; }
    public final void setOnAdd(EventHandler<ActionEvent> value) {
        EventHandler<ActionEvent> current = add.getOnAction();
        add.setOnAction(e -> {
            if(current!=null){
                current.handle(e);
            }
            value.handle(e);
        });
        onAddEvent = value;
//        add.setOnAction(value);
    }
    public final EventHandler<ActionEvent> getOnAdd() { return onAddProperty().get(); }
    private ObjectProperty<EventHandler<ActionEvent>> onAdd = new ObjectPropertyBase<>() {
        @Override protected void invalidated() { setEventHandler(ActionEvent.ACTION, get()); }
        @Override public Object getBean() { return CardContainer.this; }
        @Override public String getName() { return "onAdd"; }
    };

    public final ObjectProperty<EventHandler<ActionEvent>> onSaveProperty() { return onSave; }
    public final void setOnSave(EventHandler<ActionEvent> value) {
        EventHandler<ActionEvent> current = save.getOnAction();
        save.setOnAction(e -> {
            if(current!=null){
                current.handle(e);
            }
            value.handle(e);
        });
        onSaveEvent = value;
//        save.setOnAction(value);
    }
    public final EventHandler<ActionEvent> getOnSave() { return onSaveProperty().get(); }
    private ObjectProperty<EventHandler<ActionEvent>> onSave = new ObjectPropertyBase<>() {
        @Override protected void invalidated() { setEventHandler(ActionEvent.ACTION, get()); }
        @Override public Object getBean() { return CardContainer.this; }
        @Override public String getName() { return "onSave"; }
    };

    public final ObjectProperty<EventHandler<ActionEvent>> onDeleteProperty() { return onDelete; }
    public final void setOnDelete(EventHandler<ActionEvent> value) {
        EventHandler<ActionEvent> current = delete.getOnAction();
        delete.setOnAction(e -> {
            if(current!=null){
                current.handle(e);
            }
            value.handle(e);
        });
        onDeleteEvent = value;
//        delete.setOnAction(value);
    }
    public final EventHandler<ActionEvent> getOnDelete() { return onDeleteProperty().get(); }
    private ObjectProperty<EventHandler<ActionEvent>> onDelete = new ObjectPropertyBase<>() {
        @Override protected void invalidated() { setEventHandler(ActionEvent.ACTION, get()); }
        @Override public Object getBean() { return CardContainer.this; }
        @Override public String getName() { return "onDelete"; }
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

    @FXML
    protected void add() {
        System.out.println("On Add Internal Task Test");
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

        for (T item : getItems()) {
            item.setSelected(Boolean.TRUE);
        }
    }

    @FXML
    protected void uncheckAll() {
        checkAll.setDisable(Boolean.FALSE);
        edit.setDisable(Boolean.TRUE);
        delete.setDisable(Boolean.TRUE);

        for (T item : getItems()) {
            item.setSelected(Boolean.FALSE);
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
        edit.setDisable(Boolean.TRUE);
        cancel.setDisable(Boolean.TRUE);
        uncheckAll.setDisable(Boolean.FALSE);
    }

    //TODO priority high
    public ProjectUnit getClickedCard() {//TODO change type
        for (T item : getItems()) {
            if (item.getClicked()) {
                item.setClicked(Boolean.FALSE);
                return item.getProjectUnit();
            }
        }
        return null;
    }

    public List<ProjectUnit> getSelectedCards() {
        List<ProjectUnit> result = new ArrayList<>();
        for (T item : getItems()) {
            if (item.getCheckBox().isSelected()) {
                result.add(item.getProjectUnit());
            }
        }
        return result;
    }

//    public void setValues(List<ProjectUnit> projectUnits) {
//        cardPane.getChildren().clear();
//        cards = new ArrayList<>();
//
//        for (ProjectUnit projectUnit : projectUnits) {
//            ProjectPosition projectPosition = new ProjectPosition();
//
//            projectPosition.setProjectUnit(projectUnit);
//
//            projectPosition.setOnAction(testEvent);//TODO test
//            projectPosition.setOnSelect(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent e) {
//                    delete.setDisable(Boolean.FALSE);
//                    System.out.println("Test ProjectView: " + projectPosition);
//                }
//            });
//
//            cards.add(projectPosition);
//
//            cardPane.getChildren().add(projectPosition);
//        }
//    }
}
