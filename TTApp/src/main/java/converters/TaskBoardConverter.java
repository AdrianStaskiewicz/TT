package converters;

import controls.planningview.PlanningViewPositionUnit;
import controls.planningview.PlanningViewReleaseUnit;
import controls.planningview.PlanningViewUnit;
import controls.taskview.TaskUnit;
import dtos.ReleaseDto;
import dtos.TaskDto;

import java.util.ArrayList;
import java.util.List;

public class TaskBoardConverter {

    public static TaskUnit dtoToUnit(TaskDto dto){
        return TaskUnit.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .person(dto.getAssignTo().toString())
                .progress(dto.getProgress())
                .build();
    }


    public static List<TaskUnit> dtosToUnits(List<TaskDto> dtos){
        List<TaskUnit> units = new ArrayList<>();

        for(TaskDto taskDto : dtos){
            units.add(dtoToUnit(taskDto));
        }

        return units;
    }

}
