package requests;

import dtos.ReleaseDto;
import entities.Release;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import others.ReleaseVersionNumberPack;
import parameters.Settings;

import java.util.List;

public class ReleaseRequest {

    public static final String CATEGORY = "release/";

    public ReleaseDto getById(Long releaseId) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(releaseId, null);

        ResponseEntity<ReleaseDto> response = restTemplate.exchange(Settings.URL + CATEGORY + "get", HttpMethod.POST, requestUpdate, ReleaseDto.class);
        ReleaseDto result = response.getBody();

        return result;
    }

    public List<ReleaseDto> getAllUpcomingAssignedToProjectByProjectId(Long projectId) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(projectId, null);

        ResponseEntity<List<ReleaseDto>> response = restTemplate.exchange(Settings.URL + CATEGORY + "getallupcomingassignedtoproject", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<ReleaseDto>>() {
        });
        List<ReleaseDto> result = response.getBody();

        return result;
    }

    public List<ReleaseDto> getAllReleasedAssignedToProjectByProjectId(Long projectId) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(projectId, null);

        ResponseEntity<List<ReleaseDto>> response = restTemplate.exchange(Settings.URL + CATEGORY + "getallreleasedassignedtoproject", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<ReleaseDto>>() {
        });
        List<ReleaseDto> result = response.getBody();

        return result;
    }

    public List<ReleaseDto> getAllArchivedAssignedToProjectByProjectId(Long projectId) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(projectId, null);

        ResponseEntity<List<ReleaseDto>> response = restTemplate.exchange(Settings.URL + CATEGORY + "getallarchivedassignedtoproject", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<ReleaseDto>>() {
        });
        List<ReleaseDto> result = response.getBody();

        return result;
    }

    public Boolean checkReleaseVersionNumberAvailabilityForProjectByProjectId(Integer majorNumber, Integer minorNumber, Integer releaseNumber, Integer buildNumber, Long projectId) {
        RestTemplate restTemplate = new RestTemplate();

        ReleaseVersionNumberPack releaseVersionNumberPack = new ReleaseVersionNumberPack(majorNumber, minorNumber, releaseNumber, buildNumber, projectId);
        HttpEntity<ReleaseVersionNumberPack> requestUpdate = new HttpEntity<>(releaseVersionNumberPack, null);

        ResponseEntity<Boolean> response = restTemplate.exchange(Settings.URL + CATEGORY + "checkreleaseversionnumberavailabilityforproject", HttpMethod.POST, requestUpdate, Boolean.class);
        Boolean result = response.getBody();

        return result;
    }
    //TODO EXTRA METHODS HERE

//    public List<ReleaseDto> findAllByFarmId(Long farmId) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpEntity<List<ReleaseDto>> requestUpdate = new HttpEntity<>(farmId, null);//TODO SHOULD THIS BE HERE?
//
//        ResponseEntity<List<ReleaseDto>> response = restTemplate.exchange(Settings.URL + "getlist", HttpMethod.POST, null, new ParameterizedTypeReference<List<ReleaseDto>>() {});
//        List<ReleaseDto> accountListResult = response.getBody();
//
//        return accountListResult;
//    }
//
//    public List<AccountRowModelDto> findAllAccountsWithPersonData() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpEntity<List<Release>> requestUpdate = new HttpEntity<>(releases, null);//TODO SHOULD THIS BE HERE?
//
//        ResponseEntity<List<AccountRowModelDto>> response = restTemplate.exchange(Settings.URL + "getlist", HttpMethod.POST, null, new ParameterizedTypeReference<List<AccountRowModelDto>>() {});
//        List<AccountRowModelDto> accountListResult = response.getBody();
//
//        return accountListResult;
//    }
//        TODO PREVIOUS METHOD TEMPLATE

    public Release save(Release release) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Release> requestUpdate = new HttpEntity<>(release, null);

        ResponseEntity<Release> response = restTemplate.exchange(Settings.URL + CATEGORY + "save", HttpMethod.POST, requestUpdate, Release.class);
        Release result = response.getBody();

        return result;
    }

    public List<Release> save(List<Release> releases) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<List<Release>> requestUpdate = new HttpEntity<>(releases, null);

        ResponseEntity<List<Release>> response = restTemplate.exchange(Settings.URL + CATEGORY + "savelist", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<Release>>() {
        });
        List<Release> result = response.getBody();

        return result;
    }

    public void delete(Release release) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Release> requestUpdate = new HttpEntity<>(release, null);

        restTemplate.exchange(Settings.URL + CATEGORY + "delete", HttpMethod.DELETE, requestUpdate, Release.class);
    }

    public void delete(List<Release> releases) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<List<Release>> requestUpdate = new HttpEntity<>(releases, null);

        restTemplate.exchange(Settings.URL + CATEGORY + "deletelist", HttpMethod.DELETE, requestUpdate, new ParameterizedTypeReference<List<Release>>() {
        });
    }
}
