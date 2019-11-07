package server.services;

import dtos.ProjectDto;
import entities.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.repositories.ProjectRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Service for Project
 */
@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    @Inject
    ProjectRepository projectRepository;

    @Override
    public ProjectDto getById(Long projectId) {
        return projectRepository.getById(projectId);
    }

    @Override
    public List<ProjectDto> getAllAssignedToUserByUserId(Long userId) {
        return projectRepository.getAllAssignedToUserByUserId(userId);
    }

    @Override
    public List<ProjectDto> getAllActiveAssignedToUserByUserId(Long userId) {
        return projectRepository.getAllActiveAssignedToUserByUserId(userId);
    }

    @Override
    public List<ProjectDto> getAllUpcomingAssignedToUserByUserId(Long userId) {
        return projectRepository.getAllUpcomingAssignedToUserByUserId(userId);
    }

    @Override
    public List<ProjectDto> getAllEndedAssignedToUserByUserId(Long userId) {
        return projectRepository.getAllEndedAssignedToUserByUserId(userId);
    }

    @Override
    public ProjectDto getFirstAssignedToUserByUserId(Long userId) {
        return projectRepository.getFirstAssignedToUserByUserId(userId);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.saveCustom(project);
    }

    @Override
    public List<Project> save(List<Project> projects) {
        return projectRepository.saveCustom(projects);
    }

    @Override
    public void delete(Project project) {
        projectRepository.deleteCustom(project);
    }

    @Override
    public void delete(List<Project> projects) {
        projectRepository.deleteCustom(projects);
    }
}
