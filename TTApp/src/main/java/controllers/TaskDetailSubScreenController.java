package controllers;

import dtos.TaskDto;
import entities.Task;
import enums.TaskStatus;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import lombok.Getter;
import lombok.Setter;
import requests.TaskRequest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static enums.TaskStatus.*;

public class TaskDetailSubScreenController implements Initializable {

    @Getter
    @Setter
    private MainScreenController mainScreenController;

    @FXML
    private Label priority;
    @FXML
    private ProgressBar progress;
    @FXML
    private Slider progressSlider;
    @FXML
    private Label progressValue;
    @FXML
    private Label status;
    @FXML
    private Button changeStatus;

    @FXML
    private Label number;
    @FXML
    private Label title;

    @FXML
    private Label projectName;
    @FXML
    private Label category;

    @FXML
    private TextArea description;

//    TODO private Label estimated and spent time

    @FXML
    private Label type;
    @FXML
    private Label assignedTo;
    @FXML
    private Label targetRelease;
    @FXML
    private Label createdBy;
    @FXML
    private Label createdDate;
    @FXML
    private Label modificationDate;

    @FXML
    private Label commentsQuantity;
    @FXML
    private Label viewsQuantity;
    @FXML
    private Label subscribersQuantity;

    private TaskRequest taskRequest;
    private TaskDto data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        progressSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                progress.progressProperty().setValue(new_val.doubleValue() / 100);
                progressValue.setText(((Integer) new_val.intValue()).toString());
            }
        });
    }

    public void initializeData(Long taskId) {
        this.taskRequest = new TaskRequest();
        data = taskRequest.findById(taskId);

        setDataToControlls();

        changeControlls();
    }

    private void setDataToControlls() {
        priority.setText(data.getPriority().toString());
        progress.setProgress(data.getProgress() / 100);
        progressSlider.setValue(data.getProgress());
        progressValue.setText(String.valueOf(data.getProgress().intValue()));
        status.setText(data.getStatus().toString());

        number.setText(data.getTaskNumber().toString());
        title.setText(data.getTitle());

        projectName.setText(data.getProject().getTitle());//TODO to change
        category.setText(data.getCategory().toString());

        if (data.getDescription() != null) {
            description.setText(data.getDescription());
        }

        type.setText(data.getType().toString());
        assignedTo.setText(data.getAssignTo().getDisplayName());//TODO to change
//        targetRelease.setText(data.getRelease().getReleaseNumber().toString());//TODO to change
        createdBy.setText(data.getCreatedBy().toString());//TODO to change
        createdDate.setText(data.getCreatedDate().toString());
        if (data.getLastModifiedDate() != null) {
            modificationDate.setText(data.getLastModifiedDate().toString());
        } else {
            modificationDate.setText("");
        }

//        commentsQuantity.setText();//TODO to change
//        viewsQuantity.setText();//TODO to change
//        subscribersQuantity.setText();//TODO to change
    }

    private void changeControlls() {
        switch (data.getStatus()) {
            case NEW:
                changeStatus.setText("Close");
                break;
            case OPEN:
                changeStatus.setText("Close");
                break;
            case CLOSED:
                changeStatus.setText("Reopen");
                break;
            default:
                break;
        }
    }

    private TaskDto collectData() {
        TaskDto taskDto = new TaskDto();

        return taskDto;
    }

    private Boolean validate() {
        Boolean valid = Boolean.TRUE;


        return valid;
    }

    private void saveAfterStatusChanged() {
        Task task = taskRequest.save(data.toEntity());
        data = new TaskDto(task);
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

    @FXML
    public void createTask() {
        goToCreateTaskScreen();
    }

    @FXML
    public void save() {

    }

    @FXML
    public void cancelEditing() {

    }

    @FXML
    public void enableEditing() {

    }

    @FXML
    public void delete() {

    }

    @FXML
    public void changeStatus() {
        switch (data.getStatus()) {
            case NEW:
                data.setProgress(100.0);
                data.setStatus(TaskStatus.CLOSED);

                changeStatus.setText("Reopen");
                break;
            case OPEN:
                data.setProgress(100.0);
                data.setStatus(TaskStatus.CLOSED);

                changeStatus.setText("Reopen");
                break;
            case CLOSED:
                if (data.getProgress() == 100.0) {
                    data.setProgress(95.0);
                }
                data.setStatus(TaskStatus.OPEN);

                changeStatus.setText("Close");
                break;
            default:
                break;
        }
        progress.setProgress(data.getProgress() / 100);
        progressSlider.setValue(data.getProgress());
        progressValue.setText(String.valueOf(data.getProgress().intValue()));
        status.setText(data.getStatus().toString());

        saveAfterStatusChanged();
        setDataToControlls();

    }


}
