package edu.miu.cs.cs544.raymond.jobsearch.service;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    public List<Company> getAllCompanies();
    public Optional<Company> getCompany(long company_id);
//    public Company getCompany1(long company_id);
    public Company addCompany(Company company);
    public Company updateCompany(long company_id, Company companyDetails);
    public void deleteCompany(long company_id);
}
