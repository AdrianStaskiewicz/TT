package converters;

import controls.planningview.PlanningViewPositionUnit;
import controls.planningview.PlanningViewReleaseUnit;
import controls.planningview.PlanningViewUnit;
import dtos.ReleaseDto;
import dtos.TaskDto;

import java.util.ArrayList;
import java.util.List;

public class PlanningConverter {

    public static PlanningViewReleaseUnit dtoToUnit(ReleaseDto dto){
        return PlanningViewReleaseUnit.builder()
                .id(dto.getId())
                .title(dto.getReleaseNumberToString()+" "+dto.getName())
                .build();
    }

    public static PlanningViewPositionUnit dtoToUnit(TaskDto dto){
        return PlanningViewPositionUnit.builder()
                .id(dto.getId())
                .isSelected(Boolean.FALSE)
                .title(dto.getTitle())
                .person(dto.getAssignTo().toString())
                .progress(dto.getProgress())
                .build();
    }

    public static List<PlanningViewPositionUnit> dtosToUnits(List<TaskDto> dtos){
        List<PlanningViewPositionUnit> units = new ArrayList<>();

        for(TaskDto taskDto : dtos){
            units.add(dtoToUnit(taskDto));
        }

        return units;
    }

    public static PlanningViewUnit dtosToUnit(ReleaseDto releaseDto, List<TaskDto> taskDtos){
        return PlanningViewUnit.builder()
                .release(dtoToUnit(releaseDto))
                .positions(dtosToUnits(taskDtos))
                .build();
    }
}
