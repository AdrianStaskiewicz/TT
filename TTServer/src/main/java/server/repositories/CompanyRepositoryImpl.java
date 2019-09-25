package server.repositories;

import com.querydsl.jpa.impl.JPAQueryFactory;
import dtos.CompanyDto;
import entities.Company;
import entities.QCompany;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class CompanyRepositoryImpl implements CompanyRepositoryCustom {

    @Inject
    private EntityManager em;

    @Override
    public CompanyDto getById(Long companyId) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QCompany company = QCompany.company;

        CompanyDto result = (CompanyDto) query.select(company)
                .from(company)
                .where(company.id.eq(companyId))
                .fetch();

        return result;
    }

    @Override
    public Company saveCustom(Company company) {
        company = em.merge(company);
        em.flush();

        return company;
    }

    @Override
    public List<Company> saveCustom(List<Company> companies) {
        List<Company> result = new ArrayList<>();

        for (Company e : companies) {
            result.add(em.merge(e));
        }
        em.flush();

        return result;
    }

    @Override
    public void deleteCustom(Company company) {
        em.remove(em.contains(company) ? company : em.merge(company));
    }

    @Override
    public void deleteCustom(List<Company> companies) {
        for (Company e : companies) {
            em.remove(em.contains(e) ? e : em.merge(e));
        }
    }
}
