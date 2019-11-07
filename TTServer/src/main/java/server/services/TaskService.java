package server.services;

import dtos.TaskDto;
import entities.Task;

import java.util.List;

public interface TaskService {

    TaskDto getById(Long taskId);

    List<TaskDto> getAllProductBacklogByProjectId(Long projectId);

    List<TaskDto> getAllAssignedToReleaseByReleaseId(Long releaseId);

    Task save(Task task);

    List<Task> save(List<Task> tasks);

    void delete(Task task);

    void delete(List<Task> tasks);
}
