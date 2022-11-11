package kg.City.practice.dao;

import kg.City.practice.model.Company;

import java.util.List;

public interface CompanyDao {

    void addCompany(Company company);
    List<Company> getAllCompanies();
    Company getCompanyById(Long id);
    void updateCompany(Company company);

    void deleteCompany(Company company);
}
