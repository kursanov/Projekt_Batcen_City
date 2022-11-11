package kg.City.practice.dao;


import kg.City.practice.model.Company;
import kg.City.practice.model.Course;
import kg.City.practice.model.Group;
import kg.City.practice.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Comparator;
import java.util.List;

@Repository
@Transactional
public class CompanyDaoImpl implements CompanyDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addCompany(Company company) {
        entityManager.persist(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = entityManager.createQuery("FROM Company",Company.class).getResultList();
        Comparator<Company> comparator =(((o1, o2) -> (int) (o1.getCompanyId() - o2.getCompanyId())));
        companies.sort(comparator);
        return companies;
    }

    @Override
    public Company getCompanyById(Long id) {
        return entityManager.find(Company.class,id);
    }

    @Override
    public void updateCompany(Company company) {
        entityManager.merge(company);
    }

    @Override
    public void deleteCompany(Company company) {
        entityManager.remove(entityManager.contains(company)?company:entityManager.merge(company));
    }
}
