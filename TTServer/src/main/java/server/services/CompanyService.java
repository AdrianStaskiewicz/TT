package server.services;

import dtos.CompanyDto;
import entities.Company;

import java.util.List;

public interface CompanyService {

    CompanyDto getById(Long companyId);

    List<CompanyDto> getAllConnectedToUserByUserId(Long userId);

    Company save(Company company);

    List<Company> save(List<Company> companies);

    void delete(Company company);

    void delete(List<Company> companies);
}
