package converters;

import controls.projectview.ProjectModel;
import dtos.ProjectDto;

public class ProjectConverter {

    public static ProjectModel dtoToUnit(ProjectDto projectDto) {
        ProjectModel model = ProjectModel.builder()
                .description(projectDto.getDescription())
                .company(projectDto.getCompany() != null ? projectDto.getCompany().toString() : "")
                .startDate(projectDto.getStartDate())
                .endDate(projectDto.getEndDate())
                .build();
        model.select(Boolean.FALSE);
        model.setHeader(projectDto.getTitle());

        return model;
    }
}
