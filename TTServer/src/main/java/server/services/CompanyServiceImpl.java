package server.services;

import dtos.CompanyDto;
import entities.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.repositories.CompanyRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Service for Company
 */
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    @Inject
    CompanyRepository companyRepository;

    @Override
    public CompanyDto getById(Long companyId) {
        return companyRepository.getById(companyId);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.saveCustom(company);
    }

    @Override
    public List<Company> save(List<Company> companies) {
        return companyRepository.saveCustom(companies);
    }

    @Override
    public void delete(Company company) {
        companyRepository.deleteCustom(company);
    }

    @Override
    public void delete(List<Company> companies) {
        companyRepository.deleteCustom(companies);
    }
}
