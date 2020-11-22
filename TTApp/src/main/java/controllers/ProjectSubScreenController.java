package controllers;

import controls.projectview.ProjectUnit;
import controls.projectview.ProjectView;
import converters.ProjectConverter;
import dtos.ProjectDto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.Getter;
import lombok.Setter;
import requests.ProjectRequest;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class ProjectSubScreenController extends AbstractSubScreenController{

    @Getter
    @Setter
    private MainScreenController mainScreenController;

    @FXML
    private Button activeProjects;
    @FXML
    private Button upcomingProjects;
    @FXML
    private Button endedProjects;
    @FXML
    private ProjectView projectView;

    private ProjectRequest projectRequest;

    @FXML
    public void createTask() {
        mainScreenController.enableAllButtons();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.projectRequest = new ProjectRequest();
    }

    @Override
    public void initializeData() {
        activeProjects.setDisable(Boolean.TRUE);
        List<ProjectDto> projectDtos = projectRequest.getAllActiveAssignedToUserByUserId(mainScreenController.getContextHandler().getCurrentUser().getId());

        List<ProjectUnit> projectUnits = new LinkedList<>();

        for (ProjectDto projectDto : projectDtos) {
            projectUnits.add(ProjectConverter.dtoToUnit(projectDto));
        }

        projectView.setValue(projectUnits);
    }

    @FXML
    public void addProject() {

        Parent root = null;

        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource("/views/AddProjectPopup.fxml"));
//        ResourceBundle bundle = ResourceBundle.getBundle("lang");
//        innerLoader.setResources(bundle);

        try {
            root = innerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AddProjectPopupController addProjectPopupController;
        addProjectPopupController = innerLoader.getController();

        Scene popupScene = new Scene(root);
        Stage newWindow = new Stage();

        newWindow.initStyle(StageStyle.UNDECORATED);
        newWindow.initStyle(StageStyle.TRANSPARENT);
        popupScene.setFill(Color.TRANSPARENT);

//       this.stage.getScene();
        newWindow.initOwner(projectView.getScene().getWindow());
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.setScene(popupScene);
        newWindow.setResizable(false);

//        popupScreenController.setScene(popupScene);
        addProjectPopupController.setStage(newWindow);
        addProjectPopupController.setCurrentUser(mainScreenController.getContextHandler().getCurrentUser());
        addProjectPopupController.initializeData();

        newWindow.showAndWait();

        refreshSelectedProjectList();
        mainScreenController.getContextHandler().setAvailableProjects(projectRequest.getAllActiveAssignedToUserByUserId(mainScreenController.getContextHandler().getCurrentUser().getId()));
        mainScreenController.getContextHandler().setCurrentProject(mainScreenController.getContextHandler().getAvailableProjects().get(mainScreenController.getContextHandler().getAvailableProjects().size() - 1));
        mainScreenController.refreshProjectListAndSelectLastCreated();
    }

    @FXML
    public void deleteProject() {
        System.out.println("Deleting projects(" + projectView.getSelectedPositions().size()+")");
    }

    @FXML
    public void activeProjects() {
        activeProjects.setDisable(Boolean.TRUE);
        upcomingProjects.setDisable(Boolean.FALSE);
        endedProjects.setDisable(Boolean.FALSE);

        getAllActiveProjects();
    }

    @FXML
    public void upcomingProjects() {
        activeProjects.setDisable(Boolean.FALSE);
        upcomingProjects.setDisable(Boolean.TRUE);
        endedProjects.setDisable(Boolean.FALSE);

        getAllUpcomingProjects();
    }

    @FXML
    public void endedProjects() {
        activeProjects.setDisable(Boolean.FALSE);
        upcomingProjects.setDisable(Boolean.FALSE);
        endedProjects.setDisable(Boolean.TRUE);

        getAllEndedProjects();
    }

    private void refreshSelectedProjectList() {
        if (activeProjects.isDisable()) {
            getAllActiveProjects();
        } else if (upcomingProjects.isDisable()) {
            getAllUpcomingProjects();
        } else if (endedProjects.isDisable()) {
            getAllEndedProjects();
        }
    }

    private void getAllActiveProjects() {
        List<ProjectDto> projectDtos = projectRequest.getAllActiveAssignedToUserByUserId(mainScreenController.getContextHandler().getCurrentUser().getId());

        List<ProjectUnit> projectUnits = new LinkedList<>();

        for (ProjectDto projectDto : projectDtos) {
            projectUnits.add(ProjectConverter.dtoToUnit(projectDto));
        }

        projectView.setValue(projectUnits);
    }

    private void getAllUpcomingProjects() {
        List<ProjectDto> projectDtos = projectRequest.getAllUpcomingAssignedToUserByUserId(mainScreenController.getContextHandler().getCurrentUser().getId());

        List<ProjectUnit> projectUnits = new LinkedList<>();

        for (ProjectDto projectDto : projectDtos) {
            projectUnits.add(ProjectConverter.dtoToUnit(projectDto));
        }

        projectView.setValue(projectUnits);
    }

    private void getAllEndedProjects() {
        List<ProjectDto> projectDtos = projectRequest.getAllEndedAssignedToUserByUserId(mainScreenController.getContextHandler().getCurrentUser().getId());

        List<ProjectUnit> projectUnits = new LinkedList<>();

        for (ProjectDto projectDto : projectDtos) {
            projectUnits.add(ProjectConverter.dtoToUnit(projectDto));
        }

        projectView.setValue(projectUnits);
    }

    @Override
    public void refreshData(){
        System.out.println("REFRESH dla project subscreen'a");
    }
}
