package edu.miu.cs.cs544.raymond.jobsearch.service;

import edu.miu.cs.cs544.raymond.jobsearch.model.Company;

import java.util.List;

public interface CompanyService {

    public List<Company> getAllCompanies();
    public Company getCompany(long company_id);
    public Company addCompany(Company company);
}
