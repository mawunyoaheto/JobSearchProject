package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.model.Company;
import edu.miu.cs.cs544.raymond.jobsearch.repository.CompanyRepository;
import edu.miu.cs.cs544.raymond.jobsearch.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompany(long company_id) {
        return companyRepository.getById(company_id);
    }

    @Override
    public Company addCompany(Company company) {
        companyRepository.save(company);
        long savedCompany = company.getId();
        return companyRepository.getById(savedCompany);
    }

    @Override
    public void updateCompany(long company_id, Company companyDetails) {
        Company company = companyRepository.getById(company_id);
//                .orElseThrow(()->new ResourceNotFoundEception("Skill not found for this id :: "+skill_id));
    }

    @Override
    public void deleteCompany(long company_id) {
        companyRepository.deleteById(company_id);
    }
}

