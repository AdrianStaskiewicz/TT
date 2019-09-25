package server.repositories;

import dtos.TaskDto;
import entities.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepositoryCustom {

    TaskDto getById(Long taskId);

    Task saveCustom(Task task);

    List<Task> saveCustom(List<Task> tasks);

    void deleteCustom(Task task);

    void deleteCustom(List<Task> tasks);
}