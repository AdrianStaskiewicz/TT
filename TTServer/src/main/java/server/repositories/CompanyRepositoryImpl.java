package server.repositories;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dtos.CompanyDto;
import entities.Company;
import entities.QCompany;
import entities.QConnection;

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
    public List<CompanyDto> getAllConnectedToUserByUserId(Long userId){
        JPAQueryFactory query = new JPAQueryFactory(em);

        QCompany company = QCompany.company;
        QConnection connection = QConnection.connection;

        return (List<CompanyDto>) query.select(Projections.constructor(CompanyDto.class, company))
                .from(company)
                .leftJoin(connection)
                .on(connection.company.id.eq(company.id))
                .where(connection.worker.id.eq(userId))
                .fetch();
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
