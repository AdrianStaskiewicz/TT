package controllers;

import controls.planningview.PlanningView;
import converters.PlanningConverter;
import dtos.ReleaseDto;
import dtos.TaskDto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import lombok.Getter;
import lombok.Setter;
import requests.ReleaseRequest;
import requests.TaskRequest;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    private PlanningView planningView;

    private TaskRequest taskRequest;
    private ReleaseRequest releaseRequest;


    @FXML
    public void createTask() {
        goToCreateTaskScreen();
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

        this.taskRequest = new TaskRequest();
        this.releaseRequest = new ReleaseRequest();

        all.setDisable(Boolean.TRUE);

//        backlog = new PlanningRelease();
//        backlog.setValue();
//        backlogPane.getChildren().add(backlog);//TODO change
//        backlog.setHeader("Product backlog");//TODO change to setting whole pack

//        backlog.setValue(planningUnits);
//        //TODO CHANGE TO CREATING NEW ONE ONLY WHEN YOU GOT SOME DATA FROM REPO FOR ODER RELEASE THAN BACKLOG
//        releasePane.getChildren().add(new PlanningRelease());//TODO for a moment
//        releasePane.getChildren().add(new PlanningRelease());//TODO for a moment
    }

    public void initializeData() {
        List<TaskDto> taskDtos = new ArrayList<>();

        ReleaseDto backlog = new ReleaseDto();
        backlog.setName("Backlog");
        taskDtos = taskRequest.getAllProductBacklogByProjectId(mainScreenController.getContextHandler().getCurrentProject().getId());

        planningView.setLeftSideValue(PlanningConverter.dtosToUnit(backlog, taskDtos));

        List<ReleaseDto> releases = new ArrayList<>();
        releases = releaseRequest.getAllUpcomingAssignedToProjectByProjectId(mainScreenController.getContextHandler().getCurrentProject().getId());

        for (ReleaseDto releaseDto : releases) {
            taskDtos = taskRequest.getAllAssignedToReleaseByReleaseId(releaseDto.getId());

            planningView.setRightSideValue(PlanningConverter.dtosToUnit(releaseDto, taskDtos));
        }

    }

    public void goToCreateTaskScreen() {
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

    public void goToTaskDetailScreenWithDataInitialization(Long taskId) {
        mainScreenController.enableAllButtons();

        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource("/views/TaskDetailSubScreen2.fxml"));
//        ResourceBundle bundle = ResourceBundle.getBundle("gui.resources.lang");
//        innerLoader.setResources(bundle);

        GridPane gridPane = null;
        try {
            gridPane = innerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TaskDetailSubScreenController controller = innerLoader.getController();
        //TODO set main screen controller here
        controller.initializeData(taskId);
        controller.setMainScreenController(mainScreenController);
//        controller.initializeData();
//        set objects here

        mainScreenController.setView(gridPane);
    }

    @FXML
    public void goToDetailReleaseScreen() {
        System.out.println(planningView.getReleaseValue());
    }

    @FXML
    public void goToDetailTaskScreen() {
        goToTaskDetailScreenWithDataInitialization(planningView.getPositionValue());
    }

    private void enableAllButtons() {
        assignedToMe.setDisable(Boolean.FALSE);
        unassigned.setDisable(Boolean.FALSE);
        all.setDisable(Boolean.FALSE);
    }

}
