package controllers;

import dtos.ReleaseDto;
import dtos.TaskDto;
import dtos.UserDto;
import entities.Task;
import enums.TaskCategory;
import enums.TaskPriority;
import enums.TaskStatus;
import enums.TaskType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lombok.Getter;
import lombok.Setter;
import requests.ReleaseRequest;
import requests.TaskRequest;
import requests.UserRequest;
import utils.WorkTimeUtil;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class CreateTaskSubScreenController extends AbstractSubScreenController {

    @Getter
    @Setter
    private MainScreenController mainScreenController;

    @FXML
    private RadioButton functionality;
    @FXML
    private RadioButton compatibility;
    @FXML
    private RadioButton usability;
    @FXML
    private RadioButton security;
    @FXML
    private RadioButton performance;
    @FXML
    private RadioButton integration;
    @FXML
    private RadioButton none;


    @FXML
    private ComboBox<ReleaseDto> release;//TODO change to own component

    @FXML
    private TextField title;
    @FXML
    private TextArea description;

    @FXML
    private ComboBox<TaskType> type;
    @FXML
    private ComboBox<TaskPriority> priority;
    @FXML
    private ComboBox<UserDto> assign;
    @FXML
    private Slider progressSlider; //TODO change to own component
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label progressValue;
    @FXML
    private TextField estimatedTime;
    @FXML
    private TextField spentTime;

    @FXML
    private Button createTask;

    private ReleaseRequest releaseRequest;
    private UserRequest userRequest;
    private TaskRequest taskRequest;


    @FXML
    public void createTask() {
        if (validate()) {
            TaskDto taskDto = collectData();

            Task task = taskRequest.save(taskDto.toEntity());

        }
    }

    private Boolean validate() {
        Boolean valid = Boolean.TRUE;
        if (getSelectedCategory() == null) {
            valid = Boolean.FALSE;
        } else if(title.getText().isEmpty()){
            valid = Boolean.FALSE;
        } else if (estimatedTime.getText().isEmpty() && !WorkTimeUtil.checkStringFormatCorectness(estimatedTime.getText())) {
            valid = Boolean.FALSE;
        } else if (spentTime.getText().isEmpty() && !WorkTimeUtil.checkStringFormatCorectness(spentTime.getText())) {
            valid = Boolean.FALSE;
        } else if (getSelectedCategory() == null) {
            valid = Boolean.FALSE;
        }

        return valid;
    }

    private TaskDto collectData() {
        TaskDto data = new TaskDto();

        data.setCategory(getSelectedCategory());
        data.setTaskNumber(1);//TODO get this number from repository //TODO IS NOT NEEDED
        data.setProject(mainScreenController.getContextHandler().getCurrentProject().toEntity());
        if (release.getValue().getId() != null) {//TODO .getSelectionModel().getSelectedItem()??
            data.setRelease(release.getValue().toEntity());
        } else {
            data.setRelease(null);
        }
        data.setTitle(title.getText());
        if(!description.getText().isEmpty()){
            data.setDescription(description.getText());
        }else{
            data.setDescription(null);//TODO is not needed
        }
        data.setType(type.getValue());
        data.setPriority(priority.getValue());
        data.setStatus(TaskStatus.NEW);
        if (assign.getValue().getId() != null) {//TODO .getSelectionModel().getSelectedItem()??
            data.setAssignTo(assign.getValue().toEntity());
        } else {
            data.setAssignTo(null);//TODO IS NOT NEEDED
        }
        data.setProgress(progressSlider.getValue());
        if(!estimatedTime.getText().isEmpty()){
            data.setEstimatedTime(WorkTimeUtil.convertToNumber(estimatedTime.getText()));
        }
        if(!spentTime.getText().isEmpty()){
            data.setSpentTime(WorkTimeUtil.convertToNumber(spentTime.getText()));
        }
        data.setCreatedBy(mainScreenController.getContextHandler().getCurrentUser().toEntity());
        data.setCreatedDate(new Date());
        data.setLastModifiedDate(null); //TODO IS NOT NEEDED

        return data;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //TODO add release

        TaskType[] taskTypes = TaskType.values();

        ObservableList<TaskType> taskTypeList = FXCollections.observableArrayList(taskTypes);
        type.setItems(taskTypeList);
        type.getSelectionModel().select(0);

        TaskPriority[] taskPriorities = TaskPriority.values();

        ObservableList<TaskPriority> taskPriorityList = FXCollections.observableArrayList(taskPriorities);
        priority.setItems(taskPriorityList);
        priority.getSelectionModel().select(0);

        //TODO add assign

        progressSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                System.out.println(new_val.doubleValue());
                progressBar.progressProperty().setValue(new_val.doubleValue() / 100);
                progressValue.setText(((Integer) new_val.intValue()).toString());
//                opacityValue.setText(String.format("%.2f", new_val));
            }
        });

        this.taskRequest = new TaskRequest();
    }

    public void initializeData() {
        this.releaseRequest = new ReleaseRequest();
        //TODO CHANGE TO NEW CUSTOM MODULE
        ReleaseDto backlog = new ReleaseDto();
        backlog.setName("None/Backlog");
        List<ReleaseDto> releaseDtos = releaseRequest.getAllUpcomingAssignedToProjectByProjectId(mainScreenController.getContextHandler().getCurrentProject().getId());
        releaseDtos.add(backlog);
        ObservableList<ReleaseDto> releaseDtoList = FXCollections.observableArrayList(releaseDtos);
        release.setItems(releaseDtoList);
        release.getSelectionModel().select(0);

        this.userRequest = new UserRequest();
        UserDto none = new UserDto();
        none.setDisplayName("(None)");
        List<UserDto> userDtos = userRequest.getAllAssignedToProjectByProjectId(mainScreenController.getContextHandler().getCurrentProject().getId());
        userDtos.add(none);
        ObservableList<UserDto> userDtoList = FXCollections.observableArrayList(userDtos);
        assign.setItems(userDtoList);
        assign.getSelectionModel().select(0);
    }

    private TaskCategory getSelectedCategory() {
        if (functionality.isSelected()) {
            return TaskCategory.FUNCTIONALITY;
        } else if (compatibility.isSelected()) {
            return TaskCategory.COMPATIBILITY;
        } else if (usability.isSelected()) {
            return TaskCategory.USABILITY;
        } else if (security.isSelected()) {
            return TaskCategory.SECURITY;
        } else if (performance.isSelected()) {
            return TaskCategory.PERFORMANCE;
        } else if (integration.isSelected()) {
            return TaskCategory.INTEGRATION;
        } else if (none.isSelected()) {
            return TaskCategory.NONE;
        }
        return null;
    }

}
