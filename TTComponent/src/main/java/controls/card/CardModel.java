package controls.card;

import javafx.fxml.FXML;
import lombok.Getter;
import lombok.Setter;

public class CardModel {

    @Getter
    @Setter
    protected int id;
    @Getter
    @Setter
    protected String header;

    protected Boolean selected;

    public Boolean isSelected() {
        return selected != null ? this.selected : Boolean.FALSE;
    }

    public void select(Boolean value){
        this.selected = value;
    }

}
