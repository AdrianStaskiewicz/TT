package requests;

import dtos.TaskDto;
import entities.Task;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import parameters.Settings;

import java.util.List;

public class TaskRequest {

    public static final String CATEGORY = "task/";

    public TaskDto findById(Long taskId) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(taskId, null);

        ResponseEntity<TaskDto> response = restTemplate.exchange(Settings.URL + CATEGORY + "get", HttpMethod.POST, requestUpdate, TaskDto.class);
        TaskDto result = response.getBody();

        return result;
    }

    public List<TaskDto> getAllProductBacklogByProjectId(Long projectId){
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(projectId, null);

        ResponseEntity<List<TaskDto>> response = restTemplate.exchange(Settings.URL + CATEGORY + "getallproductbacklog", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<TaskDto>>() {
        });
        List<TaskDto> result = response.getBody();

        return result;

    }

    public List<TaskDto> getAllAssignedToReleaseByReleaseId(Long releaseId){
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(releaseId, null);

        ResponseEntity<List<TaskDto>> response = restTemplate.exchange(Settings.URL + CATEGORY + "getallassignedtorelease", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<TaskDto>>() {
        });
        List<TaskDto> result = response.getBody();

        return result;
    }

    public List<TaskDto> getAllTodoAssignedToReleaseByReleaseId(Long releaseId){
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(releaseId, null);

        ResponseEntity<List<TaskDto>> response = restTemplate.exchange(Settings.URL + CATEGORY + "getalltodoassignedtorelease", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<TaskDto>>() {
        });
        List<TaskDto> result = response.getBody();

        return result;
    }

    public List<TaskDto> getAllBusyAssignedToReleaseByReleaseId(Long releaseId){
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(releaseId, null);

        ResponseEntity<List<TaskDto>> response = restTemplate.exchange(Settings.URL + CATEGORY + "getallbusyassignedtorelease", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<TaskDto>>() {
        });
        List<TaskDto> result = response.getBody();

        return result;
    }

    public List<TaskDto> getAllDoneAssignedToReleaseByReleaseId(Long releaseId){
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(releaseId, null);

        ResponseEntity<List<TaskDto>> response = restTemplate.exchange(Settings.URL + CATEGORY + "getalldoneassignedtorelease", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<TaskDto>>() {
        });
        List<TaskDto> result = response.getBody();

        return result;
    }
    //TODO EXTRA METHODS HERE

//    public List<TaskDto> findAllByFarmId(Long farmId) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpEntity<List<TaskDto>> requestUpdate = new HttpEntity<>(farmId, null);//TODO SHOULD THIS BE HERE?
//
//        ResponseEntity<List<TaskDto>> response = restTemplate.exchange(Settings.URL + "getlist", HttpMethod.POST, null, new ParameterizedTypeReference<List<TaskDto>>() {});
//        List<TaskDto> accountListResult = response.getBody();
//
//        return accountListResult;
//    }
//
//    public List<AccountRowModelDto> findAllAccountsWithPersonData() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpEntity<List<Task>> requestUpdate = new HttpEntity<>(tasks, null);//TODO SHOULD THIS BE HERE?
//
//        ResponseEntity<List<AccountRowModelDto>> response = restTemplate.exchange(Settings.URL + "getlist", HttpMethod.POST, null, new ParameterizedTypeReference<List<AccountRowModelDto>>() {});
//        List<AccountRowModelDto> accountListResult = response.getBody();
//
//        return accountListResult;
//    }
//        TODO PREVIOUS METHOD TEMPLATE

    public Task save(Task task) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Task> requestUpdate = new HttpEntity<>(task, null);

        ResponseEntity<Task> response = restTemplate.exchange(Settings.URL + CATEGORY + "save", HttpMethod.POST, requestUpdate, Task.class);
        Task result = response.getBody();

        return result;
    }

    public List<Task> save(List<Task> tasks) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<List<Task>> requestUpdate = new HttpEntity<>(tasks, null);

        ResponseEntity<List<Task>> response = restTemplate.exchange(Settings.URL + CATEGORY + "savelist", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<Task>>() {
        });
        List<Task> result = response.getBody();

        return result;
    }

    public void delete(Task task) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Task> requestUpdate = new HttpEntity<>(task, null);

        restTemplate.exchange(Settings.URL + CATEGORY + "delete", HttpMethod.DELETE, requestUpdate, Task.class);
    }

    public void delete(List<Task> tasks) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<List<Task>> requestUpdate = new HttpEntity<>(tasks, null);

        restTemplate.exchange(Settings.URL + CATEGORY + "deletelist", HttpMethod.DELETE, requestUpdate, new ParameterizedTypeReference<List<Task>>() {
        });
    }
}
