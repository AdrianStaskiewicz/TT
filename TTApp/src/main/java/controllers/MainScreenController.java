package controllers;

import context.ContextHandler;
import dtos.ProjectDto;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import lombok.Getter;
import lombok.Setter;
import requests.UserRequest;
import requests.ProjectRequest;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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

    private UserRequest userRequest;
    private ProjectRequest projectRequest;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.contextHandler = new ContextHandler();
        this.userRequest = new UserRequest();
        this.projectRequest = new ProjectRequest();

        projectList.valueProperty().addListener((observable, oldValue, newValue) -> {
            contextHandler.setCurrentProject(newValue);
        });
    }

    public void initializeData() {
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

        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource("/views/PlanningSubScreen.fxml"));
//        ResourceBundle bundle = ResourceBundle.getBundle("gui.resources.lang");
//        innerLoader.setResources(bundle);

        GridPane gridPane = null;
        try {
            gridPane = innerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PlanningSubScreenController controller = innerLoader.getController();
        controller.setMainScreenController(this);
        controller.initializeData();
//        set objects here

        setView(gridPane);
    }

    @FXML
    private void taskBoard() {
        enableAllButtons();
        taskBoard.setDisable(Boolean.TRUE);

        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource("/views/TaskBoardSubScreen.fxml"));
//        ResourceBundle bundle = ResourceBundle.getBundle("gui.resources.lang");
//        innerLoader.setResources(bundle);

        GridPane gridPane = null;
        try {
            gridPane = innerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TaskBoardSubScreenController controller = innerLoader.getController();
        controller.setMainScreenController(this);
//        set objects here

        setView(gridPane);
    }

    @FXML
    private void workItem() {
        enableAllButtons();
        workItem.setDisable(Boolean.TRUE);

        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource("/views/WorkItemSubScreen.fxml"));
//        ResourceBundle bundle = ResourceBundle.getBundle("gui.resources.lang");
//        innerLoader.setResources(bundle);

        GridPane gridPane = null;
        try {
            gridPane = innerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        WorkItemSubScreenController controller = innerLoader.getController();
        controller.setMainScreenController(this);
//        set objects here

        setView(gridPane);
    }

    @FXML
    private void search() {
        enableAllButtons();
        workItem.setDisable(Boolean.TRUE);

        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource("/views/WorkItemSubScreen.fxml"));
//        ResourceBundle bundle = ResourceBundle.getBundle("gui.resources.lang");
//        innerLoader.setResources(bundle);

        GridPane gridPane = null;
        try {
            gridPane = innerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        WorkItemSubScreenController controller = innerLoader.getController();
        controller.setMainScreenController(this);
//        set objects here

        setView(gridPane);
    }

    @FXML
    private void projects() {
        enableAllButtons();
        projects.setDisable(Boolean.TRUE);

        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource("/views/ProjectSubScreen.fxml"));
//        ResourceBundle bundle = ResourceBundle.getBundle("gui.resources.lang");
//        innerLoader.setResources(bundle);

        GridPane gridPane = null;
        try {
            gridPane = innerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ProjectSubScreenController controller = innerLoader.getController();
        controller.setMainScreenController(this);
        controller.initializeData();
//        set objects here

        setView(gridPane);
    }

    @FXML
    private void releases() {
        enableAllButtons();
        releases.setDisable(Boolean.TRUE);

        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource("/views/ReleaseSubScreen.fxml"));
//        ResourceBundle bundle = ResourceBundle.getBundle("gui.resources.lang");
//        innerLoader.setResources(bundle);

        GridPane gridPane = null;
        try {
            gridPane = innerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ReleaseSubScreenController controller = innerLoader.getController();
        controller.setMainScreenController(this);
        controller.initializeData();

//        set objects here

        setView(gridPane);
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
    }


    public void setView(GridPane gridPane) {
        stackPane.getChildren().clear();
        stackPane.getChildren().add(gridPane);
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
}
