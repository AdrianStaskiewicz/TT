package controls.card;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Card extends GridPane {

    @FXML
    @Getter
    @Setter
    protected CheckBox checkBox;

    @FXML
    @Getter
    @Setter
    protected Button title;

    @Getter
    @Setter
    private Boolean clicked;

    @Getter
    private CardModel cardModel;

    public Card() {
    }

    public void setCardModel(CardModel cardModel) {
        this.cardModel = cardModel;
    }

    public void setSelected() {
        cardModel.select(checkBox.isSelected());
    }

    public void setClicked() {
        clicked = Boolean.TRUE;
    }

    public void setSelected(Boolean select) {
        checkBox.setSelected(select);
        cardModel.select(select);
    }

    //TODO test
    public final void setOnAction(EventHandler<ActionEvent> value) {
        EventHandler<ActionEvent> current = title.getOnAction();
        title.setOnAction(e -> {
            if (current != null) {
                current.handle(e);
            }
            value.handle(e);
        });
    }

    //TODO test
    public final void setOnSelect(EventHandler<ActionEvent> value) {
        EventHandler<ActionEvent> current = checkBox.getOnAction();
        checkBox.setOnAction(e -> {
            if (current != null) {
                current.handle(e);
            }
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
            return Card.this;//SwipeSelector.this;
        }

        @Override
        public String getName() {
            return "onAction";
        }
    };
}
