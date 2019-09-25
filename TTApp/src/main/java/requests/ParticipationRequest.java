package requests;

import dtos.ParticipationDto;
import entities.Participation;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import parameters.Settings;

import java.util.List;

public class ParticipationRequest {

    public static final String CATEGORY = "participation/";

    public ParticipationDto getById(Long participationId) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(participationId, null);

        ResponseEntity<ParticipationDto> response = restTemplate.exchange(Settings.URL + CATEGORY + "get", HttpMethod.POST, requestUpdate, ParticipationDto.class);
        ParticipationDto result = response.getBody();

        return result;
    }

    //TODO EXTRA METHODS HERE

//    public List<ParticipationDto> findAllByFarmId(Long farmId) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpEntity<List<ParticipationDto>> requestUpdate = new HttpEntity<>(farmId, null);//TODO SHOULD THIS BE HERE?
//
//        ResponseEntity<List<ParticipationDto>> response = restTemplate.exchange(Settings.URL + "getlist", HttpMethod.POST, null, new ParameterizedTypeReference<List<ParticipationDto>>() {});
//        List<ParticipationDto> accountListResult = response.getBody();
//
//        return accountListResult;
//    }
//
//    public List<AccountRowModelDto> findAllAccountsWithPersonData() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpEntity<List<Participation>> requestUpdate = new HttpEntity<>(participations, null);//TODO SHOULD THIS BE HERE?
//
//        ResponseEntity<List<AccountRowModelDto>> response = restTemplate.exchange(Settings.URL + "getlist", HttpMethod.POST, null, new ParameterizedTypeReference<List<AccountRowModelDto>>() {});
//        List<AccountRowModelDto> accountListResult = response.getBody();
//
//        return accountListResult;
//    }
//        TODO PREVIOUS METHOD TEMPLATE

    public Participation save(Participation participation) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Participation> requestUpdate = new HttpEntity<>(participation, null);

        ResponseEntity<Participation> response = restTemplate.exchange(Settings.URL + CATEGORY + "save", HttpMethod.POST, requestUpdate, Participation.class);
        Participation result = response.getBody();

        return result;
    }

    public List<Participation> save(List<Participation> participations) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<List<Participation>> requestUpdate = new HttpEntity<>(participations, null);

        ResponseEntity<List<Participation>> response = restTemplate.exchange(Settings.URL + CATEGORY + "savelist", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<Participation>>() {
        });
        List<Participation> result = response.getBody();

        return result;
    }

    public void delete(Participation participation) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Participation> requestUpdate = new HttpEntity<>(participation, null);

        restTemplate.exchange(Settings.URL + CATEGORY + "delete", HttpMethod.DELETE, requestUpdate, Participation.class);
    }

    public void delete(List<Participation> participations) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<List<Participation>> requestUpdate = new HttpEntity<>(participations, null);

        restTemplate.exchange(Settings.URL + CATEGORY + "deletelist", HttpMethod.DELETE, requestUpdate, new ParameterizedTypeReference<List<Participation>>() {
        });
    }
}