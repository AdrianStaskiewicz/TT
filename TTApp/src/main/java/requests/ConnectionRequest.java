package requests;

import dtos.ConnectionDto;
import entities.Connection;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import parameters.Settings;

import java.util.List;

public class ConnectionRequest {

    public static final String CATEGORY = "connection/";

    public ConnectionDto findById(Long connectionId) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(connectionId, null);

        ResponseEntity<ConnectionDto> response = restTemplate.exchange(Settings.URL + CATEGORY + "get", HttpMethod.POST, requestUpdate, ConnectionDto.class);
        ConnectionDto result = response.getBody();

        return result;
    }

    //TODO EXTRA METHODS HERE

//    public List<ConnectionDto> findAllByFarmId(Long farmId) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpEntity<List<ConnectionDto>> requestUpdate = new HttpEntity<>(farmId, null);//TODO SHOULD THIS BE HERE?
//
//        ResponseEntity<List<ConnectionDto>> response = restTemplate.exchange(Settings.URL + "getlist", HttpMethod.POST, null, new ParameterizedTypeReference<List<ConnectionDto>>() {});
//        List<ConnectionDto> accountListResult = response.getBody();
//
//        return accountListResult;
//    }
//
//    public List<AccountRowModelDto> findAllAccountsWithPersonData() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpEntity<List<Connection>> requestUpdate = new HttpEntity<>(connections, null);//TODO SHOULD THIS BE HERE?
//
//        ResponseEntity<List<AccountRowModelDto>> response = restTemplate.exchange(Settings.URL + "getlist", HttpMethod.POST, null, new ParameterizedTypeReference<List<AccountRowModelDto>>() {});
//        List<AccountRowModelDto> accountListResult = response.getBody();
//
//        return accountListResult;
//    }
//        TODO PREVIOUS METHOD TEMPLATE

    public Connection save(Connection connection) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Connection> requestUpdate = new HttpEntity<>(connection, null);

        ResponseEntity<Connection> response = restTemplate.exchange(Settings.URL + CATEGORY + "save", HttpMethod.POST, requestUpdate, Connection.class);
        Connection result = response.getBody();

        return result;
    }

    public List<Connection> save(List<Connection> connections) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<List<Connection>> requestUpdate = new HttpEntity<>(connections, null);

        ResponseEntity<List<Connection>> response = restTemplate.exchange(Settings.URL + CATEGORY + "savelist", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<Connection>>() {
        });
        List<Connection> result = response.getBody();

        return result;
    }

    public void delete(Connection connection) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Connection> requestUpdate = new HttpEntity<>(connection, null);

        restTemplate.exchange(Settings.URL + CATEGORY + "delete", HttpMethod.DELETE, requestUpdate, Connection.class);
    }

    public void delete(List<Connection> connections) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<List<Connection>> requestUpdate = new HttpEntity<>(connections, null);

        restTemplate.exchange(Settings.URL + CATEGORY + "deletelist", HttpMethod.DELETE, requestUpdate, new ParameterizedTypeReference<List<Connection>>() {
        });
    }
}