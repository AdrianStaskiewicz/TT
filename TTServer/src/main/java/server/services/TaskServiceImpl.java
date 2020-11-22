package server.services;

import dtos.TaskDto;
import entities.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.repositories.TaskRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Service for Task
 */
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    @Inject
    TaskRepository taskRepository;

    @Override
    public TaskDto getById(Long taskId) {
        return taskRepository.getById(taskId);
    }

    @Override
    public List<TaskDto> getAllProductBacklogByProjectId(Long projectId){
        return taskRepository.getAllProductBacklogByProjectId(projectId);
    }

    @Override
    public List<TaskDto> getAllAssignedToReleaseByReleaseId(Long releaseId){
        return taskRepository.getAllAssignedToReleaseByReleaseId(releaseId);
    }

    @Override
    public List<TaskDto> getAllTodoAssignedToReleaseByReleaseId(Long releaseId){
        return taskRepository.getAllTodoAssignedToReleaseByReleaseId(releaseId);
    }

    @Override
    public List<TaskDto> getAllBusyAssignedToReleaseByReleaseId(Long releaseId){
        return taskRepository.getAllBusyAssignedToReleaseByReleaseId(releaseId);
    }

    @Override
    public List<TaskDto> getAllDoneAssignedToReleaseByReleaseId(Long releaseId){
        return taskRepository.getAllDoneAssignedToReleaseByReleaseId(releaseId);
    }

    @Override
    public Task save(Task task) {

        Integer taskNumber = taskRepository.getNumberForNewTaskByProjectId(task.getProject().getId());
        task.setTaskNumber(taskNumber + 1);
        return taskRepository.saveCustom(task);
    }

    @Override
    public List<Task> save(List<Task> tasks) {
        return taskRepository.saveCustom(tasks);
    }

    @Override
    public void delete(Task task) {
        taskRepository.deleteCustom(task);
    }

    @Override
    public void delete(List<Task> tasks) {
        taskRepository.deleteCustom(tasks);
    }
}
