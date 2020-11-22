package server.repositories;

import dtos.TaskDto;
import entities.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepositoryCustom {

    TaskDto getById(Long taskId);

    Integer getNumberForNewTaskByProjectId(Long projectId);

    List<TaskDto> getAllProductBacklogByProjectId(Long projectId);

    List<TaskDto> getAllAssignedToReleaseByReleaseId(Long releaseId);

    List<TaskDto> getAllTodoAssignedToReleaseByReleaseId(Long releaseId);

    List<TaskDto> getAllBusyAssignedToReleaseByReleaseId(Long releaseId);

    List<TaskDto> getAllDoneAssignedToReleaseByReleaseId(Long releaseId);

    Task saveCustom(Task task);

    List<Task> saveCustom(List<Task> tasks);

    void deleteCustom(Task task);

    void deleteCustom(List<Task> tasks);
}