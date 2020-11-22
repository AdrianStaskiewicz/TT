package context;

import controllers.AbstractSubScreenController;
import dtos.ProjectDto;
import dtos.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javafx.fxml.Initializable;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ContextHandler {
    private UserDto currentUser;
    private ProjectDto currentProject;
    private List<ProjectDto> availableProjects;
    private AbstractSubScreenController currentScreenController;
}
