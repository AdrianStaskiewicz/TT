package controllers.old;

import dtos.ProjectDto;
import enums.TaskStatus;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import org.controlsfx.control.CheckComboBox;
import requests.ProjectRequest;
import requests.TaskRequest;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GeneralScreenController implements Initializable {

    @FXML
    private MenuButton project;

    @FXML
    private CheckComboBox<ProjectDto> projectList;

    @FXML
    private CheckComboBox<TaskStatus> statusList;

    private ProjectRequest projectRequest;
    private TaskRequest taskRequest;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectRequest = new ProjectRequest();
        taskRequest = new TaskRequest();

        List<ProjectDto> projectDtos = projectRequest.getAllAssignedToUserByUserId(1000000L);

//        List<String> list = new ArrayList<>();
//        list.add("tets");
//        list.stream().map(CheckMenuItem::new).forEach(project.getItems()::add);
//        for (MenuItem e : project.getItems()) {
//            if (((CheckMenuItem) e).isSelected()) {
//                ((CheckMenuItem) e).setOnAction();
//            }
//        }


        // create the data to show in the CheckComboBox
        for (ProjectDto p: projectDtos) {
            projectList.getItems().add(p);
        }

        // Create the CheckComboBox with the data
//        final CheckComboBox<String> checkComboBox = new CheckComboBox<String>(strings);

        // and listen to the relevant events (e.g. when the selected indices or
        // selected items change).
        projectList.getCheckModel().getCheckedItems().addListener(new ListChangeListener<ProjectDto>() {
            public void onChanged(ListChangeListener.Change<? extends ProjectDto> c) {
                System.out.println(projectList.getCheckModel().getCheckedItems());
            }
        });


        TaskStatus[] taskStatuses = TaskStatus.values();
        for (TaskStatus ts : taskStatuses) {
            statusList.getItems().add(ts);

        }
        statusList.getCheckModel().getCheckedItems().addListener(new ListChangeListener<TaskStatus>() {
            public void onChanged(ListChangeListener.Change<? extends TaskStatus> c) {
                System.out.println(statusList.getCheckModel().getCheckedItems());
            }
        });
    }

    @FXML
    public void filterTaskList() {
        for (MenuItem e : project.getItems()) {
            if (((CheckMenuItem) e).isSelected()) {
                System.out.println(((CheckMenuItem) e).getId());
            }
        }
    }

    public void filterTaskListWithEvenHandler(ActionEvent actionEvent) {
    }
}
