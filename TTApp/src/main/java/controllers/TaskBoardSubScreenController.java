package controllers;

import controls.taskview.TaskUnit;
import controls.taskview.TaskView;
import converters.TaskBoardConverter;
import dtos.ReleaseDto;
import dtos.TaskDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import lombok.Getter;
import lombok.Setter;
import requests.ReleaseRequest;
import requests.TaskRequest;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class TaskBoardSubScreenController implements Initializable {

    @Getter
    @Setter
    private MainScreenController mainScreenController;

    @FXML
    private ComboBox<ReleaseDto> release;
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

    private ReleaseRequest releaseRequest;
    private TaskRequest taskRequest;

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
        all.setDisable(Boolean.TRUE);

        release.setOnAction(e -> {
            refreshData();
        });

    }


    public void initializeData() {
        this.releaseRequest = new ReleaseRequest();
        this.taskRequest = new TaskRequest();

        List<ReleaseDto> releaseDtos = releaseRequest.getAllUpcomingAssignedToProjectByProjectId(mainScreenController.getContextHandler().getCurrentProject().getId());
        ObservableList<ReleaseDto> releaseDtoList = FXCollections.observableArrayList(releaseDtos);
        release.setItems(releaseDtoList);
        release.getSelectionModel().select(0);

        List<TaskDto> todoTasks = new ArrayList<>();
        List<TaskDto> busyTasks = new ArrayList<>();
        List<TaskDto> doneTasks = new ArrayList<>();

        todoTasks = taskRequest.getAllTodoAssignedToReleaseByReleaseId(release.getValue().getId());
        busyTasks = taskRequest.getAllBusyAssignedToReleaseByReleaseId(release.getValue().getId());
        doneTasks = taskRequest.getAllDoneAssignedToReleaseByReleaseId(release.getValue().getId());


        todo.setValue(TaskBoardConverter.dtosToUnits(todoTasks));
        busy.setValue(TaskBoardConverter.dtosToUnits(busyTasks));
        done.setValue(TaskBoardConverter.dtosToUnits(doneTasks));
    }

    private void refreshData() {
        List<TaskDto> todoTasks = new ArrayList<>();
        List<TaskDto> busyTasks = new ArrayList<>();
        List<TaskDto> doneTasks = new ArrayList<>();

        todoTasks = taskRequest.getAllTodoAssignedToReleaseByReleaseId(release.getValue().getId());
        busyTasks = taskRequest.getAllBusyAssignedToReleaseByReleaseId(release.getValue().getId());
        doneTasks = taskRequest.getAllDoneAssignedToReleaseByReleaseId(release.getValue().getId());

        todo.clearValue();
        todo.setValue(TaskBoardConverter.dtosToUnits(todoTasks));
        busy.clearValue();
        busy.setValue(TaskBoardConverter.dtosToUnits(busyTasks));
        done.clearValue();
        done.setValue(TaskBoardConverter.dtosToUnits(doneTasks));
    }

    private void enableAllButtons() {
        assignedToMe.setDisable(Boolean.FALSE);
        unassigned.setDisable(Boolean.FALSE);
        all.setDisable(Boolean.FALSE);
    }

    public void goToCreateTaskScreen(){
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

    public void goToTaskDetailScreenWithDataInitialization(Long taskId){
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
    public void goToTodoTask() {
        goToTaskDetailScreenWithDataInitialization(todo.getClickedPosition().getId());
    }

    @FXML
    public void goToBusyTask() {
        goToTaskDetailScreenWithDataInitialization(busy.getClickedPosition().getId());
    }

    @FXML
    public void goToDoneTask() {
        goToTaskDetailScreenWithDataInitialization(done.getClickedPosition().getId());
    }
}
