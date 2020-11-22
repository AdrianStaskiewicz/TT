package server.controllers;

import dtos.TaskDto;
import entities.Task;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.services.TaskService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @PersistenceContext
    private EntityManager em;

    @Inject
    private TaskService taskService;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResponseEntity findById(@RequestBody @Valid Long taskId, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        TaskDto taskDto = taskService.getById(taskId);

        return new ResponseEntity(taskDto, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getallproductbacklog", method = RequestMethod.POST)
    public ResponseEntity getAllProductBacklogByProjectId(@RequestBody @Valid Long projectId, BindingResult result){
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        List<TaskDto> taskDtos = taskService.getAllProductBacklogByProjectId(projectId);
//todo
        return new ResponseEntity(taskDtos, new HttpHeaders(), HttpStatus.OK);

    }

    @RequestMapping(value = "/getallassignedtorelease", method = RequestMethod.POST)
    public ResponseEntity getAllAssignedToReleaseByReleaseId(@RequestBody @Valid Long releaseId, BindingResult result){
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        List<TaskDto> taskDtos = taskService.getAllAssignedToReleaseByReleaseId(releaseId);
//todo
        return new ResponseEntity(taskDtos, new HttpHeaders(), HttpStatus.OK);

    }

    @RequestMapping(value = "/getalltodoassignedtorelease", method = RequestMethod.POST)
    public ResponseEntity getAllTodoAssignedToReleaseByReleaseId(@RequestBody @Valid Long releaseId, BindingResult result){
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        List<TaskDto> taskDtos = taskService.getAllTodoAssignedToReleaseByReleaseId(releaseId);
//todo
        return new ResponseEntity(taskDtos, new HttpHeaders(), HttpStatus.OK);

    }

    @RequestMapping(value = "/getallbusyassignedtorelease", method = RequestMethod.POST)
    public ResponseEntity getAllBusyAssignedToReleaseByReleaseId(@RequestBody @Valid Long releaseId, BindingResult result){
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        List<TaskDto> taskDtos = taskService.getAllBusyAssignedToReleaseByReleaseId(releaseId);
//todo
        return new ResponseEntity(taskDtos, new HttpHeaders(), HttpStatus.OK);

    }

    @RequestMapping(value = "/getalldoneassignedtorelease", method = RequestMethod.POST)
    public ResponseEntity getAllDoneAssignedToReleaseByReleaseId(@RequestBody @Valid Long releaseId, BindingResult result){
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        List<TaskDto> taskDtos = taskService.getAllDoneAssignedToReleaseByReleaseId(releaseId);
//todo
        return new ResponseEntity(taskDtos, new HttpHeaders(), HttpStatus.OK);

    }

    @Transactional
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody @Valid Task task, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        task = taskService.save(task);
        return new ResponseEntity(task, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/savelist", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody @Valid List<Task> tasks, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        tasks = taskService.save(tasks);
        return new ResponseEntity(tasks, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody @Valid Task task, BindingResult result) {

        taskService.delete(task);

    }

    @Transactional
    @RequestMapping(value = "/deletelist", method = RequestMethod.DELETE)
    public void delete(@RequestBody @Valid List<Task> tasks, BindingResult result) {

        taskService.delete(tasks);

    }

}
