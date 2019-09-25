package context;

import dtos.ProjectDto;
import dtos.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ContextHandler {
    private UserDto currentUser;
    private ProjectDto currentProject;
    private List<ProjectDto> availableProjects;
}
