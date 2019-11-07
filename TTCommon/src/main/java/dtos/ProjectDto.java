package dtos;

import entities.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private Long id;
    private String title;
    private String description;
    private Company company;
    private Date startDate;
    private Date endDate;

    public ProjectDto(Project project) {
        this.id = project.getId();
        this.title = project.getTitle();
        this.description = project.getDescription();
        this.company = project.getCompany();
        this.startDate = project.getStartDate();
        this.endDate = project.getEndDate();
    }

    public Project toEntity() {
        Project project = new Project();
        project.setId(this.id);
        project.setTitle(this.title);
        project.setDescription(this.description);
        project.setCompany(this.company);
        project.setStartDate(this.startDate);
        project.setEndDate(this.endDate);
        return project;
    }

    @Override
    public String toString() {
        return company!=null? title + " | " + company.toString(): title;
    }
}
