package server.controllers;

import dtos.CompanyDto;
import entities.Company;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.services.CompanyService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @PersistenceContext
    private EntityManager em;

    @Inject
    private CompanyService companyService;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResponseEntity findById(@RequestBody @Valid Long companyId, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        CompanyDto companyDto = companyService.getById(companyId);

        return new ResponseEntity(companyDto, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody @Valid Company company, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        company = companyService.save(company);
        return new ResponseEntity(company, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/savelist", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody @Valid List<Company> companies, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        companies = companyService.save(companies);
        return new ResponseEntity(companies, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody @Valid Company company, BindingResult result) {

        companyService.delete(company);

    }

    @Transactional
    @RequestMapping(value = "/deletelist", method = RequestMethod.DELETE)
    public void delete(@RequestBody @Valid List<Company> companies, BindingResult result) {

        companyService.delete(companies);

    }

}
