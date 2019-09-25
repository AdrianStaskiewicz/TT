package requests;

import dtos.CommentDto;
import entities.Comment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import others.LoginPack;
import parameters.Settings;

import java.util.List;

public class AuthenticationRequest {

    public static final String CATEGORY = "authentication/";

    public Long login(String login, String password) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<LoginPack> requestUpdate = new HttpEntity<>(new LoginPack(login, password), null);

        ResponseEntity<Long> response = restTemplate.exchange(Settings.URL + CATEGORY + "login", HttpMethod.POST, requestUpdate, Long.class);
        Long result = response.getBody();

        return result;
    }

    //TODO EXTRA METHODS HERE

//    public List<CommentDto> findAllByFarmId(Long farmId) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpEntity<List<CommentDto>> requestUpdate = new HttpEntity<>(farmId, null);//TODO SHOULD THIS BE HERE?
//
//        ResponseEntity<List<CommentDto>> response = restTemplate.exchange(Settings.URL + "getlist", HttpMethod.POST, null, new ParameterizedTypeReference<List<CommentDto>>() {});
//        List<CommentDto> accountListResult = response.getBody();
//
//        return accountListResult;
//    }
//
//    public List<AccountRowModelDto> findAllAccountsWithPersonData() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpEntity<List<Comment>> requestUpdate = new HttpEntity<>(comments, null);//TODO SHOULD THIS BE HERE?
//
//        ResponseEntity<List<AccountRowModelDto>> response = restTemplate.exchange(Settings.URL + "getlist", HttpMethod.POST, null, new ParameterizedTypeReference<List<AccountRowModelDto>>() {});
//        List<AccountRowModelDto> accountListResult = response.getBody();
//
//        return accountListResult;
//    }
//        TODO PREVIOUS METHOD TEMPLATE

    public Comment save(Comment comment) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Comment> requestUpdate = new HttpEntity<>(comment, null);

        ResponseEntity<Comment> response = restTemplate.exchange(Settings.URL + CATEGORY + "save", HttpMethod.POST, requestUpdate, Comment.class);
        Comment result = response.getBody();

        return result;
    }

    public List<Comment> save(List<Comment> comments) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<List<Comment>> requestUpdate = new HttpEntity<>(comments, null);

        ResponseEntity<List<Comment>> response = restTemplate.exchange(Settings.URL + CATEGORY + "savelist", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<Comment>>() {
        });
        List<Comment> result = response.getBody();

        return result;
    }

    public void delete(Comment comment) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Comment> requestUpdate = new HttpEntity<>(comment, null);

        restTemplate.exchange(Settings.URL + CATEGORY + "delete", HttpMethod.DELETE, requestUpdate, Comment.class);
    }

    public void delete(List<Comment> comments) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<List<Comment>> requestUpdate = new HttpEntity<>(comments, null);

        restTemplate.exchange(Settings.URL + CATEGORY + "deletelist", HttpMethod.DELETE, requestUpdate, new ParameterizedTypeReference<List<Comment>>() {
        });
    }
}