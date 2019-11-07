package controllers;

import dtos.CompanyDto;
import dtos.ParticipationDto;
import dtos.ProjectDto;
import dtos.UserDto;
import entities.Company;
import entities.Participation;
import entities.Project;
import entities.User;
import enums.RoleType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import requests.CompanyRequest;
import requests.ConnectionRequest;
import requests.ParticipationRequest;
import requests.ProjectRequest;
import utils.DateUtil;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddProjectPopupController implements Initializable {
    @FXML
    @Setter
    private Stage stage;

    @FXML
    private Button closePopup;
    @FXML
    private Button addProject;
    @FXML
    private GridPane topBar;

    @FXML
    private TextField title;
    @FXML
    private TextArea description;
    @FXML
    private ComboBox<CompanyDto> companyList;
    @FXML
    private DatePicker startDate;

    private ProjectRequest projectRequest;
    private CompanyRequest companyRequest;
    private ParticipationRequest participationRequest;

    @Getter
    @Setter
    private UserDto currentUser;

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    public void closePopup() {
//        Stage stage2 = (Stage) closePopup.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void addProject() {
        if (validate()) {
            ProjectDto projectDto = collectData();

            Project project = projectRequest.save(projectDto.toEntity());

            ParticipationDto participationDto = new ParticipationDto();
            participationDto.setProject(project);
            participationDto.setContributor(currentUser.toEntity());
            participationDto.setRole(RoleType.ADMINISTRATOR);

            participationRequest.save(participationDto.toEntity());

            stage.close();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.projectRequest = new ProjectRequest();
        this.companyRequest = new CompanyRequest();
        this.participationRequest = new ParticipationRequest();

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
    }

    public void initializeData() {
        List<CompanyDto> companies = companyRequest.getAllConnectedToUserByUserId(currentUser.getId());

        ObservableList<CompanyDto> availableProjectList = FXCollections.observableArrayList(companies);
        companyList.setItems(availableProjectList);
//        projectList.getSelectionModel().select(0);
    }

    private Boolean validate() {
        return title.getText().isEmpty() ? Boolean.FALSE : Boolean.TRUE;
    }

    private ProjectDto collectData() {
        ProjectDto data = new ProjectDto();

        data.setTitle(title.getText());
        data.setDescription(description.getText());
        if (companyList.getSelectionModel().getSelectedItem() != null) {
            data.setCompany(companyList.getSelectionModel().getSelectedItem().toEntity());
        }
        if (startDate.getValue() != null) {
            data.setStartDate(DateUtil.toDate(startDate.getValue()));
        }

        return data;
    }
}
