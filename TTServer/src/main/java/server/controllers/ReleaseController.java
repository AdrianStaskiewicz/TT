package server.controllers;

import dtos.ReleaseDto;
import entities.Release;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import others.ReleaseVersionNumberPack;
import server.services.ReleaseService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/release")
public class ReleaseController {
    @PersistenceContext
    private EntityManager em;

    @Inject
    private ReleaseService releaseService;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResponseEntity getById(@RequestBody @Valid Long releaseId, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        ReleaseDto releaseDto = releaseService.getById(releaseId);

        return new ResponseEntity(releaseDto, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getallupcomingassignedtoproject", method = RequestMethod.POST)
    public ResponseEntity getAllUpcomingAssignedToProjectByProjectId(@RequestBody @Valid Long projectId, BindingResult result){
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        List<ReleaseDto> projectDtos = releaseService.getAllUpcomingAssignedToProjectByProjectId(projectId);
//todo
        return new ResponseEntity(projectDtos, new HttpHeaders(), HttpStatus.OK);

    }


    @RequestMapping(value = "/getallreleasedassignedtoproject", method = RequestMethod.POST)
    public ResponseEntity getAllReleasedAssignedToProjectByProjectId(@RequestBody @Valid Long projectId, BindingResult result){
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        List<ReleaseDto> projectDtos = releaseService.getAllReleasedAssignedToProjectByProjectId(projectId);
//todo
        return new ResponseEntity(projectDtos, new HttpHeaders(), HttpStatus.OK);

    }

    @RequestMapping(value = "/getallarchivedassignedtoproject", method = RequestMethod.POST)
    public ResponseEntity getAllArchivedAssignedToProjectByProjectId(@RequestBody @Valid Long projectId, BindingResult result){
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        List<ReleaseDto> projectDtos = releaseService.getAllArchivedAssignedToProjectByProjectId(projectId);
//todo
        return new ResponseEntity(projectDtos, new HttpHeaders(), HttpStatus.OK);

    }

    @RequestMapping(value = "/checkreleaseversionnumberavailabilityforproject", method = RequestMethod.POST)
    public ResponseEntity checkReleaseVersionNumberAvailabilityForProjectByProjectId(@RequestBody @Valid ReleaseVersionNumberPack releaseVersionNumberPack, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Boolean response = releaseService.checkReleaseVersionNumberAvailabilityForProjectByProjectId(releaseVersionNumberPack.getMajorNumber(), releaseVersionNumberPack.getMinorNumber(), releaseVersionNumberPack.getReleaseNumber(), releaseVersionNumberPack.getBuildNumber(), releaseVersionNumberPack.getProjectId());

        return new ResponseEntity(response, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody @Valid Release release, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        release = releaseService.save(release);
        return new ResponseEntity(release, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/savelist", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody @Valid List<Release> releases, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        releases = releaseService.save(releases);
        return new ResponseEntity(releases, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody @Valid Release release, BindingResult result) {

        releaseService.delete(release);

    }

    @Transactional
    @RequestMapping(value = "/deletelist", method = RequestMethod.DELETE)
    public void delete(@RequestBody @Valid List<Release> releases, BindingResult result) {

        releaseService.delete(releases);

    }

}
