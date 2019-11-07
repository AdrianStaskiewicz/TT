package controllers;

import controls.taskview.TaskUnit;
import controls.taskview.TaskView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class TaskBoardSubScreenController implements Initializable {

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
    private VBox todoPane;
    @FXML
    private VBox busyPane;
    @FXML
    private VBox donePane;

    @FXML
    private TaskView todo;
    @FXML
    private TaskView busy;
    @FXML
    private TaskView done;

    @FXML
    public void createTask() {
        mainScreenController.enableAllButtons();

        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource("/views/CreateTaskSubScreen.fxml"));
//        ResourceBundle bundle = ResourceBundle.getBundle("gui.resources.lang");
//        innerLoader.setResources(bundle);

        GridPane gridPane = null;
        try {
            gridPane = innerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CreateTaskSubScreenController controller = innerLoader.getController();
        controller.setMainScreenController(mainScreenController);
        controller.initializeData();
//        set objects here

        mainScreenController.setView(gridPane);
    }

    @FXML
    public void assignedToMe() {
        enableAllButtons();
        assignedToMe.setDisable(Boolean.TRUE);
    }

    @FXML
    public void unassigned() {
        enableAllButtons();
        unassigned.setDisable(Boolean.TRUE);
    }

    @FXML
    public void all() {
        enableAllButtons();
        all.setDisable(Boolean.TRUE);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        all.setDisable(Boolean.TRUE);

//        todo = new taskview();
//        todoPane.getChildren().add(todo);

        //TODO TEST!
        List<TaskUnit> planningUnits = new LinkedList<>();
        planningUnits.add(TaskUnit.builder().description("Napisz swoj wlasny modul").person("Anna Nowak").progress(0.7).build());
        planningUnits.add(TaskUnit.builder().description("Przetestuj modul").person("Jan Kowalski").progress(0.9).build());
        planningUnits.add(TaskUnit.builder().description("Synchronizing different computers within a local network").person("Jan Kowal").progress(0.3).build());
        planningUnits.add(TaskUnit.builder().description("Test").person("Jan Kowal").progress(0.3).build());
        todo.setValue(planningUnits);
        //TODO CHANGE TO CREATING NEW ONE ONLY WHEN YOU GOT SOME DATA FROM REPO FOR ODER RELEASE THAN BACKLOG
//        busy = new taskview();
        busy.setValue(planningUnits);
//        busyPane.getChildren().add(busy);
//        done = new taskview();
        done.setValue(planningUnits);
//        donePane.getChildren().add(done);
//        releasePane.getChildren().add(new planningview());//TODO for a moment
//        releasePane.getChildren().add(new planningview());//TODO for a moment
    }

    private void enableAllButtons() {
        assignedToMe.setDisable(Boolean.FALSE);
        unassigned.setDisable(Boolean.FALSE);
        all.setDisable(Boolean.FALSE);
    }

    @FXML
    public void goToTodoTask(){
        System.out.println(todo.getClickedPosition());
    }

    @FXML
    public void goToBusyTask(){
        System.out.println(busy.getClickedPosition());
    }

    @FXML
    public void goToDoneTask(){
        System.out.println(done.getClickedPosition());
    }
}
