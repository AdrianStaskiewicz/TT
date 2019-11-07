package converters;

import controls.planningview.PlanningUnit;
import controls.projectview.ProjectUnit;
import dtos.ProjectDto;
import dtos.TaskDto;

public class PlanningConverter {

    public static PlanningUnit dtoToUnit(TaskDto taskDto){
        return PlanningUnit.builder()
                .select(Boolean.FALSE)
                .title(taskDto.getTitle())
                .person(taskDto.getAssignTo().toString())
                .progress(taskDto.getProgress())
                .build();
    }
}
