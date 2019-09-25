package requests;

import dtos.ProjectDto;
import entities.Project;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import parameters.Settings;

import java.util.List;

public class ProjectRequest {

    public static final String CATEGORY = "project/";

    public ProjectDto findById(Long projectId) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(projectId, null);

        ResponseEntity<ProjectDto> response = restTemplate.exchange(Settings.URL + CATEGORY + "get", HttpMethod.POST, requestUpdate, ProjectDto.class);
        ProjectDto result = response.getBody();

        return result;
    }

    public List<ProjectDto> getAllAssignedToUserByUserId(Long userId){
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(userId, null);

        ResponseEntity<List<ProjectDto>> response = restTemplate.exchange(Settings.URL + CATEGORY + "getallassignedtouser", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<ProjectDto>>() {});
        List<ProjectDto> result = response.getBody();

        return result;
    }

    public List<ProjectDto> getAllActiveAssignedToUserByUserId(Long userId){
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(userId, null);

        ResponseEntity<List<ProjectDto>> response = restTemplate.exchange(Settings.URL + CATEGORY + "getallactiveassignedtouser", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<ProjectDto>>() {});
        List<ProjectDto> result = response.getBody();

        return result;
    }

    public List<ProjectDto> getAllUpcomingAssignedToUserByUserId(Long userId){
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(userId, null);

        ResponseEntity<List<ProjectDto>> response = restTemplate.exchange(Settings.URL + CATEGORY + "getallupcomingassignedtouser", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<ProjectDto>>() {});
        List<ProjectDto> result = response.getBody();

        return result;
    }

    public List<ProjectDto> getAllEndedAssignedToUserByUserId(Long userId){
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(userId, null);

        ResponseEntity<List<ProjectDto>> response = restTemplate.exchange(Settings.URL + CATEGORY + "getallendedassignedtouser", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<ProjectDto>>() {});
        List<ProjectDto> result = response.getBody();

        return result;
    }

    public ProjectDto getFirstAssignedToUserByUserId(Long userId){
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(userId, null);

        ResponseEntity<ProjectDto> response = restTemplate.exchange(Settings.URL + CATEGORY + "getfirstassignedtouser", HttpMethod.POST, requestUpdate, ProjectDto.class);
        ProjectDto result = response.getBody();

        return result;
    }


    //TODO EXTRA METHODS HERE

//    public List<ProjectDto> findAllByFarmId(Long farmId) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpEntity<List<ProjectDto>> requestUpdate = new HttpEntity<>(farmId, null);//TODO SHOULD THIS BE HERE?
//
//        ResponseEntity<List<ProjectDto>> response = restTemplate.exchange(Settings.URL + "getlist", HttpMethod.POST, null, new ParameterizedTypeReference<List<ProjectDto>>() {});
//        List<ProjectDto> accountListResult = response.getBody();
//
//        return accountListResult;
//    }
//
//    public List<AccountRowModelDto> findAllAccountsWithPersonData() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpEntity<List<Project>> requestUpdate = new HttpEntity<>(projects, null);//TODO SHOULD THIS BE HERE?
//
//        ResponseEntity<List<AccountRowModelDto>> response = restTemplate.exchange(Settings.URL + "getlist", HttpMethod.POST, null, new ParameterizedTypeReference<List<AccountRowModelDto>>() {});
//        List<AccountRowModelDto> accountListResult = response.getBody();
//
//        return accountListResult;
//    }
//        TODO PREVIOUS METHOD TEMPLATE

    public Project save(Project project) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Project> requestUpdate = new HttpEntity<>(project, null);

        ResponseEntity<Project> response = restTemplate.exchange(Settings.URL + CATEGORY + "save", HttpMethod.POST, requestUpdate, Project.class);
        Project result = response.getBody();

        return result;
    }

    public List<Project> save(List<Project> projects) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<List<Project>> requestUpdate = new HttpEntity<>(projects, null);

        ResponseEntity<List<Project>> response = restTemplate.exchange(Settings.URL + CATEGORY + "savelist", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<Project>>() {
        });
        List<Project> result = response.getBody();

        return result;
    }

    public void delete(Project project) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Project> requestUpdate = new HttpEntity<>(project, null);

        restTemplate.exchange(Settings.URL + CATEGORY + "delete", HttpMethod.DELETE, requestUpdate, Project.class);
    }

    public void delete(List<Project> projects) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<List<Project>> requestUpdate = new HttpEntity<>(projects, null);

        restTemplate.exchange(Settings.URL + CATEGORY + "deletelist", HttpMethod.DELETE, requestUpdate, new ParameterizedTypeReference<List<Project>>() {
        });
    }

}