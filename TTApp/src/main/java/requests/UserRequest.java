package requests;

import dtos.UserDto;
import entities.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import parameters.Settings;

import java.util.List;

public class UserRequest {

    public static final String CATEGORY = "user/";

    public UserDto findById(Long userId) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(userId, null);

        ResponseEntity<UserDto> response = restTemplate.exchange(Settings.URL + CATEGORY + "get", HttpMethod.POST, requestUpdate, UserDto.class);
        UserDto result = response.getBody();

        return result;
    }

    //TODO EXTRA METHODS HERE

//    public List<UserDto> findAllByFarmId(Long farmId) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpEntity<List<UserDto>> requestUpdate = new HttpEntity<>(farmId, null);//TODO SHOULD THIS BE HERE?
//
//        ResponseEntity<List<UserDto>> response = restTemplate.exchange(Settings.URL + "getlist", HttpMethod.POST, null, new ParameterizedTypeReference<List<UserDto>>() {});
//        List<UserDto> userListResult = response.getBody();
//
//        return userListResult;
//    }
//
//    public List<UserRowModelDto> findAllUsersWithPersonData() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpEntity<List<User>> requestUpdate = new HttpEntity<>(users, null);//TODO SHOULD THIS BE HERE?
//
//        ResponseEntity<List<UserRowModelDto>> response = restTemplate.exchange(Settings.URL + "getlist", HttpMethod.POST, null, new ParameterizedTypeReference<List<UserRowModelDto>>() {});
//        List<UserRowModelDto> userListResult = response.getBody();
//
//        return userListResult;
//    }
//        TODO PREVIOUS METHOD TEMPLATE

    public User save(User user) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<User> requestUpdate = new HttpEntity<>(user, null);

        ResponseEntity<User> response = restTemplate.exchange(Settings.URL + CATEGORY + "save", HttpMethod.POST, requestUpdate, User.class);
        User result = response.getBody();

        return result;
    }

    public List<User> save(List<User> users) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<List<User>> requestUpdate = new HttpEntity<>(users, null);

        ResponseEntity<List<User>> response = restTemplate.exchange(Settings.URL + CATEGORY + "savelist", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<User>>() {
        });
        List<User> result = response.getBody();

        return result;
    }

    public void delete(User user) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<User> requestUpdate = new HttpEntity<>(user, null);

        restTemplate.exchange(Settings.URL + CATEGORY + "delete", HttpMethod.DELETE, requestUpdate, User.class);
    }

    public void delete(List<User> users) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<List<User>> requestUpdate = new HttpEntity<>(users, null);

        restTemplate.exchange(Settings.URL + CATEGORY + "deletelist", HttpMethod.DELETE, requestUpdate, new ParameterizedTypeReference<List<User>>() {
        });
    }
}
