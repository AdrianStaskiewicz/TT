package controllers;

import controls.PlanningUnit;
import controls.PlanningView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class PlanningSubScreenController implements Initializable {

    @Getter
    @Setter
    private MainScreenController mainScreenController;

    @FXML
    private Button assignedToMe;
    @FXML
    private Button unassigned;
    @FXML
    private Button all;
    @FXML
    private VBox backlogPane;
    @FXML
    private  VBox releasePane;

    private PlanningView backlog;

    private List<PlanningView> releases;


    @FXML
    public void createTask(){

    }

    @FXML
    public void assignedToMe(){
        enableAllButtons();
        assignedToMe.setDisable(Boolean.TRUE);
    }

    @FXML
    public void unassigned(){
        enableAllButtons();
        unassigned.setDisable(Boolean.TRUE);
    }

    @FXML
    public void all(){
        enableAllButtons();
        all.setDisable(Boolean.TRUE);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        all.setDisable(Boolean.TRUE);
        backlog = new PlanningView();
        backlogPane.getChildren().add(backlog);


        //TODO TEST!
        List<PlanningUnit> planningUnits = new LinkedList<>();
        planningUnits.add(PlanningUnit.builder().description("Napisz swoj wlasny modul").person("Anna Nowak").progress(0.7).build());
        planningUnits.add(PlanningUnit.builder().description("Przetestuj modul").person("Jan Kowalski").progress(0.9).build());
        planningUnits.add(PlanningUnit.builder().description("Synchronizing different computers within a local network").person("Jan Kowal").progress(0.3).build());
        planningUnits.add(PlanningUnit.builder().description("Test").person("Jan Kowal").progress(0.3).build());
        backlog.setValue(planningUnits);
        //TODO CHANGE TO CREATING NEW ONE ONLY WHEN YOU GOT SOME DATA FROM REPO FOR ODER RELEASE THAN BACKLOG
        releasePane.getChildren().add(new PlanningView());//TODO for a moment
        releasePane.getChildren().add(new PlanningView());//TODO for a moment
    }

    private void enableAllButtons(){
        assignedToMe.setDisable(Boolean.FALSE);
        unassigned.setDisable(Boolean.FALSE);
        all.setDisable(Boolean.FALSE);
    }
}
