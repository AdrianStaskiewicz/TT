package controls.projectview;

import controls.card.CardContainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.List;

public class ProjectCardContainer extends CardContainer {

    public ProjectCardContainer() {
    }

    public void setValues(ObservableList<ProjectModel> models) {

        List<ProjectCard> cards = new ArrayList<>();
        for (ProjectModel model : models) {
            ProjectCard projectCard = new ProjectCard();

            projectCard.setProjectModel(model);

            projectCard.setOnAction(onActionEvent);//TODO test
            projectCard.setOnSelect(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    delete.setDisable(Boolean.FALSE);
                }
            });

            cards.add(projectCard);
        }
        super.setItems(FXCollections.observableList(cards));
    }
}
