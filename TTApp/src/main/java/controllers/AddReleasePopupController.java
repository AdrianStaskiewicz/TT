package controllers;

import dtos.ProjectDto;
import dtos.ReleaseDto;
import entities.Release;
import enums.TargetReleaseDateType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lombok.Setter;
import requests.ReleaseRequest;
import utils.DateUtil;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddReleasePopupController implements Initializable {
    @FXML
    @Setter
    private Stage stage;

    @Setter
    private ProjectDto currentProject;

    @FXML
    private Button closePopup;
    @FXML
    private Button addRelease;
    @FXML
    private GridPane topBar;

    @FXML
    private Spinner<Integer> minor;
    @FXML
    private Spinner<Integer> major;
    @FXML
    private Spinner<Integer> release;
    @FXML
    private Spinner<Integer> build;
    @FXML
    private TextField name;
    @FXML
    private ComboBox<TargetReleaseDateType> targetReleaseDateType;
    @FXML
    private DatePicker targetReleaseDate;
    @FXML
    private TextArea focus;

    private ReleaseRequest releaseRequest;

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    public void closePopup() {
        Stage stage2 = (Stage) closePopup.getScene().getWindow();
        stage2.close();
    }

    @FXML
    public void addRelease() {
        if (validate()) {
            ReleaseDto releaseDto = collectData();

            Release release = releaseRequest.save(releaseDto.toEntity());

            stage.close();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.releaseRequest = new ReleaseRequest();

        topBar.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        topBar.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });

        SpinnerValueFactory<Integer> majorValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999, 0);
        major.setValueFactory(majorValueFactory);
        SpinnerValueFactory<Integer> minorValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999, 0);
        minor.setValueFactory(minorValueFactory);
        SpinnerValueFactory<Integer> releaseValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999, 0);
        release.setValueFactory(releaseValueFactory);
        SpinnerValueFactory<Integer> buildValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999, 0);
        build.setValueFactory(buildValueFactory);

//        List<TargetReleaseDateType> targetReleaseDateTypes = new ArrayList<>(TargetReleaseDateType.values());
        TargetReleaseDateType[] targetReleaseDateTypes = TargetReleaseDateType.values();

        ObservableList<TargetReleaseDateType> dateTypeList = FXCollections.observableArrayList(targetReleaseDateTypes);
        targetReleaseDateType.setItems(dateTypeList);
        targetReleaseDateType.getSelectionModel().select(0);
    }

    //TODO
    public void initializeData() {

    }

    //TODO
    private Boolean validate() {
        return releaseRequest.checkReleaseVersionNumberAvailabilityForProjectByProjectId(major.getValue(), minor.getValue(), release.getValue(), build.getValue(), currentProject.getId());
    }


    private ReleaseDto collectData() {
        ReleaseDto data = new ReleaseDto();

        data.setMajorNumber(major.getValue());
        data.setMinorNumber(minor.getValue());
        data.setReleaseNumber(release.getValue());
        data.setBuildNumber(build.getValue());

        data.setName(name.getText());
        data.setFocus(focus.getText());

        data.setProject(currentProject.toEntity());

        if (targetReleaseDate.getValue() != null) {
            data.setTargetReleaseDateTime(DateUtil.toDate(targetReleaseDate.getValue()));
            data.setTargetReleaseDateType(targetReleaseDateType.getValue());
        }

        return data;
    }
}
