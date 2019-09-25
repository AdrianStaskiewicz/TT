package server.repositories;

import dtos.ProjectDto;
import entities.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepositoryCustom {

    ProjectDto getById(Long projectId);

    List<ProjectDto> getAllAssignedToUserByUserId(Long userId);

    List<ProjectDto> getAllActiveAssignedToUserByUserId(Long userId);

    List<ProjectDto> getAllUpcomingAssignedToUserByUserId(Long userId);

    List<ProjectDto> getAllEndedAssignedToUserByUserId(Long userId);

    ProjectDto getFirstAssignedToUserByUserId(Long userId);

    Project saveCustom(Project project);

    List<Project> saveCustom(List<Project> projects);

    void deleteCustom(Project project);

    void deleteCustom(List<Project> projects);
}
