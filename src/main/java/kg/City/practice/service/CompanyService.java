package kg.City.practice.service;

import kg.City.practice.model.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    void  addCompany(Company company);

    Company getCompanyById(long id);

    void updateCompany(Company company);

    void deleteCompany(Company company);
}
