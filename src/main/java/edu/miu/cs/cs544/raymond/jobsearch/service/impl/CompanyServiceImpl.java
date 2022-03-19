package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Company;
import edu.miu.cs.cs544.raymond.jobsearch.exception.ResourceNotFoundException;
import edu.miu.cs.cs544.raymond.jobsearch.repository.CompanyRepository;
import edu.miu.cs.cs544.raymond.jobsearch.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
    public Optional<Company> getCompany(long company_id) {
        Optional<Company> company = companyRepository.findById(company_id);
        if(company.isPresent())
            return company;
        else{
            throw new ResourceNotFoundException("company with given id not found");
        }
    }

    public Company getOneCompany(long id){
//        return  companyRepository.findById(id).get();
        return  companyRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("company with given id not found"));
    }

    @Override
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(long company_id, Company companyDetails) {
        Company foundCompany = companyRepository.findById(company_id).get();
        if(foundCompany!=null){
          foundCompany.setName(companyDetails.getName());
          foundCompany.getAddress().setStreet(companyDetails.getAddress().getStreet());
          foundCompany.getAddress().setCity(companyDetails.getAddress().getCity());
          foundCompany.getAddress().setState(companyDetails.getAddress().getState());
          foundCompany.getAddress().setZipcode(companyDetails.getAddress().getZipcode());
           return companyRepository.save(foundCompany);
        } else{
            throw new ResourceNotFoundException("not found");
        }
    }

    @Override
    public void deleteCompany(long company_id) {
        companyRepository.deleteById(company_id);
    }
}

