package server.services;

import dtos.ProjectDto;
import entities.Project;

import java.util.List;

public interface ProjectService {

    ProjectDto getById(Long projectId);

    List<ProjectDto> getAllAssignedToUserByUserId(Long userId);

    List<ProjectDto> getAllActiveAssignedToUserByUserId(Long userId);

    List<ProjectDto> getAllUpcomingAssignedToUserByUserId(Long userId);

    List<ProjectDto> getAllEndedAssignedToUserByUserId(Long userId);

    ProjectDto getFirstAssignedToUserByUserId(Long userId);

    Project save(Project project);

    List<Project> save(List<Project> projects);

    void delete(Project project);

    void delete(List<Project> projects);
}
