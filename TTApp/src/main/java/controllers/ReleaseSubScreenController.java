package controllers;

import controls.releaseview.ReleaseUnit;
import controls.releaseview.ReleaseView;
import converters.ProjectConverter;
import converters.ReleaseConverter;
import dtos.ReleaseDto;
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
        upcomingReleases.setDisable(Boolean.TRUE);
        List<ReleaseDto> releaseDtos = releaseRequest.getAllUpcomingAssignedToProjectByProjectId(mainScreenController.getContextHandler().getCurrentProject().getId());

        List<ReleaseUnit> releaseUnits = new LinkedList<>();

        for (ReleaseDto releaseDto : releaseDtos) {
            releaseUnits.add(ReleaseConverter.dtoToUnit(releaseDto));
        }

        releaseView.setValue(releaseUnits);
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
        addReleasePopupController.setCurrentProject(mainScreenController.getContextHandler().getCurrentProject());
        addReleasePopupController.initializeData();

        newWindow.showAndWait();

        refreshSelectedReleaseList();
    }

    @FXML
    public void upcomingReleases() {
        upcomingReleases.setDisable(Boolean.TRUE);
        releasedReleases.setDisable(Boolean.FALSE);
        archivedReleases.setDisable(Boolean.FALSE);

        getAllUpcomingReleases();
    }

    @FXML
    public void releasedReleases() {
        upcomingReleases.setDisable(Boolean.FALSE);
        releasedReleases.setDisable(Boolean.TRUE);
        archivedReleases.setDisable(Boolean.FALSE);

        getAllReleasedReleases();
    }

    @FXML
    public void archivedReleases() {
        upcomingReleases.setDisable(Boolean.FALSE);
        releasedReleases.setDisable(Boolean.FALSE);
        archivedReleases.setDisable(Boolean.TRUE);

        getAllArchivedReleases();
    }

    private void refreshSelectedReleaseList() {
        if (upcomingReleases.isDisable()) {
            getAllUpcomingReleases();
        } else if (releasedReleases.isDisable()) {
            getAllReleasedReleases();
        } else if (archivedReleases.isDisable()) {
            getAllArchivedReleases();
        }
    }

    private void getAllUpcomingReleases() {
        List<ReleaseDto> releaseDtos = releaseRequest.getAllUpcomingAssignedToProjectByProjectId(mainScreenController.getContextHandler().getCurrentProject().getId());

        List<ReleaseUnit> projectUnits = new LinkedList<>();

        for (ReleaseDto releaseDto : releaseDtos) {
            projectUnits.add(ReleaseConverter.dtoToUnit(releaseDto));
        }

        releaseView.setValue(projectUnits);
    }

    private void getAllReleasedReleases() {
        List<ReleaseDto> releaseDtos = releaseRequest.getAllReleasedAssignedToProjectByProjectId(mainScreenController.getContextHandler().getCurrentProject().getId());

        List<ReleaseUnit> projectUnits = new LinkedList<>();

        for (ReleaseDto releaseDto : releaseDtos) {
            projectUnits.add(ReleaseConverter.dtoToUnit(releaseDto));
        }

        releaseView.setValue(projectUnits);
    }

    private void getAllArchivedReleases() {
        List<ReleaseDto> releaseDtos = releaseRequest.getAllArchivedAssignedToProjectByProjectId(mainScreenController.getContextHandler().getCurrentProject().getId());

        List<ReleaseUnit> projectUnits = new LinkedList<>();

        for (ReleaseDto releaseDto : releaseDtos) {
            projectUnits.add(ReleaseConverter.dtoToUnit(releaseDto));
        }

        releaseView.setValue(projectUnits);
    }
}
