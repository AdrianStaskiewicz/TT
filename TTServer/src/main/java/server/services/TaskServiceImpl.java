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
    public Task save(Task task) {
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
