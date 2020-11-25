package controllers;

import context.ContextHandler;
import dtos.ProjectDto;
import helpers.ScreenHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import lombok.Getter;
import lombok.Setter;
import parameters.ViewPath;
import requests.ProjectRequest;
import requests.UserRequest;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    @FXML
    private StackPane stackPane;

    @FXML
    private Button home;
    @FXML
    private Button planning;
    @FXML
    private Button taskBoard;
    @FXML
    private Button workItem;
    @FXML
    private ComboBox<ProjectDto> projectList;

    @FXML
    private Button projects;
    @FXML
    private Button releases;
    @FXML
    private Button releaseOverview;
    @FXML
    private Button changeLog;
    @FXML
    private Button users;

    @Getter
    @Setter
    private ContextHandler contextHandler;

    @Getter
    @Setter
    private ScreenHelper screenHelper;

    private UserRequest userRequest;
    private ProjectRequest projectRequest;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.contextHandler = new ContextHandler();
        this.userRequest = new UserRequest();
        this.projectRequest = new ProjectRequest();

        projectList.valueProperty().addListener((observable, oldValue, newValue) -> {
            contextHandler.setCurrentProject(newValue);
            refreshDataOnSubScreen();
        });
    }

    public void initializeData() {
        screenHelper.configure(stackPane);
        screenHelper.configure(this);
        contextHandler.setAvailableProjects(projectRequest.getAllActiveAssignedToUserByUserId(contextHandler.getCurrentUser().getId()));
        if (contextHandler.getAvailableProjects() != null && contextHandler.getAvailableProjects().size() > 0) {

            contextHandler.setCurrentProject(contextHandler.getAvailableProjects().get(0));

            ObservableList<ProjectDto> availableProjectList = FXCollections.observableArrayList(contextHandler.getAvailableProjects());
            projectList.setItems(availableProjectList);
            projectList.getSelectionModel().select(0);
        }
    }

    @FXML
    private void home() {
        enableAllButtons();
        home.setDisable(Boolean.TRUE);
    }

    @FXML
    private void planning() {
        enableAllButtons();
        planning.setDisable(Boolean.TRUE);
        screenHelper.goToSubScreen(ViewPath.PLANNING_SUBSCREEN);
    }

    @FXML
    private void taskBoard() {
        enableAllButtons();
        taskBoard.setDisable(Boolean.TRUE);

        screenHelper.goToSubScreen(ViewPath.TASK_BOARD_SUBSCREEN);
    }

    @FXML
    private void workItem() {
        enableAllButtons();
        workItem.setDisable(Boolean.TRUE);

        screenHelper.goToSubScreen(ViewPath.WORK_ITEM_SUBSCREEN);
    }

    @FXML
    private void search() {
        enableAllButtons();
        workItem.setDisable(Boolean.TRUE);

    }

    @FXML
    private void projects() {
        enableAllButtons();
        projects.setDisable(Boolean.TRUE);

        screenHelper.goToSubScreen(ViewPath.PROJECT_SUBSCREEN);
    }

    @FXML
    private void releases() {
        enableAllButtons();
        releases.setDisable(Boolean.TRUE);

        screenHelper.goToSubScreen(ViewPath.RELEASE_SUBSCREEN);
    }

    @FXML
    private void releaseOverview() {
        enableAllButtons();
        releaseOverview.setDisable(Boolean.TRUE);
    }

    @FXML
    private void changeLog() {
        enableAllButtons();
        changeLog.setDisable(Boolean.TRUE);
    }

    @FXML
    private void users() {
        enableAllButtons();
        users.setDisable(Boolean.TRUE);

        screenHelper.goToSubScreen(ViewPath.TEST_SUBSCREEN);
    }

    public void enableAllButtons() {
        home.setDisable(Boolean.FALSE);
        planning.setDisable(Boolean.FALSE);
        taskBoard.setDisable(Boolean.FALSE);
        workItem.setDisable(Boolean.FALSE);
        projects.setDisable(Boolean.FALSE);
        releases.setDisable(Boolean.FALSE);
        releaseOverview.setDisable(Boolean.FALSE);
        changeLog.setDisable(Boolean.FALSE);
        users.setDisable(Boolean.FALSE);
    }

    public void refreshProjectList() {
        ObservableList<ProjectDto> availableProjectList = FXCollections.observableArrayList(contextHandler.getAvailableProjects());
        projectList.setItems(availableProjectList);
    }

    public void refreshProjectListAndSelectLastCreated() {
        refreshProjectList();
        projectList.getSelectionModel().select(getContextHandler().getAvailableProjects().size() - 1);
    }

    private void refreshDataOnSubScreen() {
        if (contextHandler.getCurrentScreenController() != null) {
            contextHandler.getCurrentScreenController().refreshData();
        }
    }
}
