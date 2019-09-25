package controllers;

import controls.ProjectUnit;
import controls.ReleaseView;
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
import requests.ReleaseRequest;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class ReleaseSubScreenController implements Initializable {

    @Getter
    @Setter
    private MainScreenController mainScreenController;

    @FXML
    private Button upcomingReleases;
    @FXML
    private Button releasedReleases;
    @FXML
    private Button archivedReleases;
    @FXML
    private ReleaseView releaseView;

    private ReleaseRequest releaseRequest;

    @FXML
    public void createTask() {
        mainScreenController.enableAllButtons();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.releaseRequest = new ReleaseRequest();
    }

    public void initializeData() {
//        activeProjects.setDisable(Boolean.TRUE);
//        List<ProjectDto> projectDtos = projectRequest.getAllActiveAssignedToUserByUserId(mainScreenController.getContextHandler().getCurrentUser().getId());
//
//        List<ProjectUnit> projectUnits = new LinkedList<>();
//
//        for (ProjectDto projectDto : projectDtos) {
//            projectUnits.add(ProjectConverter.dtoToUnit(projectDto));
//        }
//
//        projectView.setValue(projectUnits);
    }

    @FXML
    public void addRelease() {

        Parent root = null;

        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource("/views/AddReleasePopup.fxml"));
//        ResourceBundle bundle = ResourceBundle.getBundle("lang");
//        innerLoader.setResources(bundle);

        try {
            root = innerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AddReleasePopupController addReleasePopupController;
        addReleasePopupController = innerLoader.getController();

        Scene popupScene = new Scene(root);
        Stage newWindow = new Stage();

        newWindow.initStyle(StageStyle.UNDECORATED);
        newWindow.initStyle(StageStyle.TRANSPARENT);
        popupScene.setFill(Color.TRANSPARENT);

//       this.stage.getScene();
        newWindow.initOwner(releaseView.getScene().getWindow());
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.setScene(popupScene);
        newWindow.setResizable(false);

//        popupScreenController.setScene(popupScene);
        addReleasePopupController.setStage(newWindow);

        newWindow.showAndWait();
    }

    @FXML
    public void upcomingReleases(){
//        activeProjects.setDisable(Boolean.TRUE);
//        upcomingProjects.setDisable(Boolean.FALSE);
//        endedProjects.setDisable(Boolean.FALSE);
//
//        List<ProjectDto> projectDtos = projectRequest.getAllActiveAssignedToUserByUserId(mainScreenController.getContextHandler().getCurrentUser().getId());
//
//        List<ProjectUnit> projectUnits = new LinkedList<>();
//
//        for (ProjectDto projectDto : projectDtos) {
//            projectUnits.add(ProjectConverter.dtoToUnit(projectDto));
//        }
//
//        projectView.setValue(projectUnits);
    }

    @FXML
    public void releasedReleases(){
//        activeProjects.setDisable(Boolean.FALSE);
//        upcomingProjects.setDisable(Boolean.TRUE);
//        endedProjects.setDisable(Boolean.FALSE);
//
//        List<ProjectDto> projectDtos = projectRequest.getAllUpcomingAssignedToUserByUserId(mainScreenController.getContextHandler().getCurrentUser().getId());
//
//        List<ProjectUnit> projectUnits = new LinkedList<>();
//
//        for (ProjectDto projectDto : projectDtos) {
//            projectUnits.add(ProjectConverter.dtoToUnit(projectDto));
//        }
//
//        projectView.setValue(projectUnits);
    }

    @FXML
    public void archivedReleases(){
//        activeProjects.setDisable(Boolean.FALSE);
//        upcomingProjects.setDisable(Boolean.FALSE);
//        endedProjects.setDisable(Boolean.TRUE);
//
//        List<ProjectDto> projectDtos = projectRequest.getAllEndedAssignedToUserByUserId(mainScreenController.getContextHandler().getCurrentUser().getId());
//
//        List<ProjectUnit> projectUnits = new LinkedList<>();
//
//        for (ProjectDto projectDto : projectDtos) {
//            projectUnits.add(ProjectConverter.dtoToUnit(projectDto));
//        }
//
//        projectView.setValue(projectUnits);
    }
}
