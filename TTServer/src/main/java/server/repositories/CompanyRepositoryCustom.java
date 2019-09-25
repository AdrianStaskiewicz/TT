package server.repositories;

import dtos.CompanyDto;
import entities.Company;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepositoryCustom {

    CompanyDto getById(Long companyId);

    Company saveCustom(Company company);

    List<Company> saveCustom(List<Company> companies);

    void deleteCustom(Company company);

    void deleteCustom(List<Company> companies);
}
