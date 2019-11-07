package converters;

import controls.projectview.ProjectUnit;
import dtos.ProjectDto;

public class ProjectConverter {

    public static ProjectUnit dtoToUnit(ProjectDto projectDto){
        return ProjectUnit.builder()
                .select(Boolean.FALSE)
                .title(projectDto.getTitle())
                .description(projectDto.getDescription())
                .company(projectDto.getCompany()!=null?projectDto.getCompany().toString():"")
                .startDate(projectDto.getStartDate())
                .endDate(projectDto.getEndDate())
                .build();
    }
}
