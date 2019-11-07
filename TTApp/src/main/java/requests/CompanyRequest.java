package requests;

import dtos.CompanyDto;
import entities.Company;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import parameters.Settings;

import java.util.List;

public class CompanyRequest {

    public static final String CATEGORY = "company/";

    public CompanyDto findById(Long companyId) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(companyId, null);

        ResponseEntity<CompanyDto> response = restTemplate.exchange(Settings.URL + CATEGORY + "get", HttpMethod.POST, requestUpdate, CompanyDto.class);
        CompanyDto result = response.getBody();

        return result;
    }

    public List<CompanyDto> getAllConnectedToUserByUserId(Long userId){
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Long> requestUpdate = new HttpEntity<>(userId, null);

        ResponseEntity<List<CompanyDto>> response = restTemplate.exchange(Settings.URL + CATEGORY + "getallconnectedtouser", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<CompanyDto>>() {});
        List<CompanyDto> result = response.getBody();

        return result;
    }

    //TODO EXTRA METHODS HERE

//    public List<CompanyDto> findAllByFarmId(Long farmId) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpEntity<List<CompanyDto>> requestUpdate = new HttpEntity<>(farmId, null);//TODO SHOULD THIS BE HERE?
//
//        ResponseEntity<List<CompanyDto>> response = restTemplate.exchange(Settings.URL + "getlist", HttpMethod.POST, null, new ParameterizedTypeReference<List<CompanyDto>>() {});
//        List<CompanyDto> accountListResult = response.getBody();
//
//        return accountListResult;
//    }
//
//    public List<AccountRowModelDto> findAllAccountsWithPersonData() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpEntity<List<Company>> requestUpdate = new HttpEntity<>(companys, null);//TODO SHOULD THIS BE HERE?
//
//        ResponseEntity<List<AccountRowModelDto>> response = restTemplate.exchange(Settings.URL + "getlist", HttpMethod.POST, null, new ParameterizedTypeReference<List<AccountRowModelDto>>() {});
//        List<AccountRowModelDto> accountListResult = response.getBody();
//
//        return accountListResult;
//    }
//        TODO PREVIOUS METHOD TEMPLATE

    public Company save(Company company) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Company> requestUpdate = new HttpEntity<>(company, null);

        ResponseEntity<Company> response = restTemplate.exchange(Settings.URL + CATEGORY + "save", HttpMethod.POST, requestUpdate, Company.class);
        Company result = response.getBody();

        return result;
    }

    public List<Company> save(List<Company> companies) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<List<Company>> requestUpdate = new HttpEntity<>(companies, null);

        ResponseEntity<List<Company>> response = restTemplate.exchange(Settings.URL + CATEGORY + "savelist", HttpMethod.POST, requestUpdate, new ParameterizedTypeReference<List<Company>>() {
        });
        List<Company> result = response.getBody();

        return result;
    }

    public void delete(Company company) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Company> requestUpdate = new HttpEntity<>(company, null);

        restTemplate.exchange(Settings.URL + CATEGORY + "delete", HttpMethod.DELETE, requestUpdate, Company.class);
    }

    public void delete(List<Company> companies) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<List<Company>> requestUpdate = new HttpEntity<>(companies, null);

        restTemplate.exchange(Settings.URL + CATEGORY + "deletelist", HttpMethod.DELETE, requestUpdate, new ParameterizedTypeReference<List<Company>>() {
        });
    }
}