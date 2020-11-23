package controls.projectview;

import controls.card.Card;
import controls.dateview.DateView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@AllArgsConstructor
public class ProjectCard extends Card {

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
    private ProjectModel projectModel;

    public ProjectCard() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ProjectPosition.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        checkBox.setSelected(Boolean.FALSE);
        this.clicked = Boolean.FALSE;
    }

    public void setProjectModel(ProjectModel projectModel) {
        this.projectModel = projectModel;
        this.setCardModel(projectModel);

        checkBox.setSelected(projectModel.isSelected());
        title.setText(projectModel.getHeader());
        company.setText(projectModel.getCompany());
        description.setText(projectModel.getDescription());
        if(projectModel.getStartDate() != null){
            startDate.setValue(projectModel.getStartDate());
        }
        if(projectModel.getEndDate() != null){
            endDate.setValue(projectModel.getEndDate());
        }
    }

    @FXML
    public void setSelected(){
        super.setSelected();
    }
}
