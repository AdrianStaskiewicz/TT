package server.controllers;

import dtos.ProjectDto;
import entities.Project;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.services.ProjectService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @PersistenceContext
    private EntityManager em;

    @Inject
    private ProjectService projectService;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResponseEntity findById(@RequestBody @Valid Long projectId, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        ProjectDto projectDto = projectService.getById(projectId);

        return new ResponseEntity(projectDto, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getallassignedtouser", method = RequestMethod.POST)
    public ResponseEntity getAllAssignedToUserByUserId(@RequestBody @Valid Long userId, BindingResult result){
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        List<ProjectDto> projectDtos = projectService.getAllAssignedToUserByUserId(userId);
//todo
        return new ResponseEntity(projectDtos, new HttpHeaders(), HttpStatus.OK);

    }
    @RequestMapping(value = "/getallactiveassignedtouser", method = RequestMethod.POST)
    public ResponseEntity getAllActiveAssignedToUserByUserId(@RequestBody @Valid Long userId, BindingResult result){
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        List<ProjectDto> projectDtos = projectService.getAllActiveAssignedToUserByUserId(userId);
//todo
        return new ResponseEntity(projectDtos, new HttpHeaders(), HttpStatus.OK);

    }
    @RequestMapping(value = "/getallupcomingassignedtouser", method = RequestMethod.POST)
    public ResponseEntity getAllUpcomingAssignedToUserByUserId(@RequestBody @Valid Long userId, BindingResult result){
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        List<ProjectDto> projectDtos = projectService.getAllUpcomingAssignedToUserByUserId(userId);
//todo
        return new ResponseEntity(projectDtos, new HttpHeaders(), HttpStatus.OK);

    }
    @RequestMapping(value = "/getallendedassignedtouser", method = RequestMethod.POST)
    public ResponseEntity getAllEndedAssignedToUserByUserId(@RequestBody @Valid Long userId, BindingResult result){
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        List<ProjectDto> projectDtos = projectService.getAllEndedAssignedToUserByUserId(userId);
//todo
        return new ResponseEntity(projectDtos, new HttpHeaders(), HttpStatus.OK);

    }

    @RequestMapping(value = "/getfirstassignedtouser", method = RequestMethod.POST)
    public ResponseEntity getFirstAssignedToUserByUserId(@RequestBody @Valid Long userId, BindingResult result){
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        ProjectDto projectDto = projectService.getFirstAssignedToUserByUserId(userId);
//todo
        return new ResponseEntity(projectDto, new HttpHeaders(), HttpStatus.OK);

    }

    @Transactional
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody @Valid Project project, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        project = projectService.save(project);
        return new ResponseEntity(project, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/savelist", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody @Valid List<Project> projects, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        projects = projectService.save(projects);
        return new ResponseEntity(projects, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody @Valid Project project, BindingResult result) {

        projectService.delete(project);

    }

    @Transactional
    @RequestMapping(value = "/deletelist", method = RequestMethod.DELETE)
    public void delete(@RequestBody @Valid List<Project> projects, BindingResult result) {

        projectService.delete(projects);

    }

}
