package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.model.Company;
import edu.miu.cs.cs544.raymond.jobsearch.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
//    @Autowired
//    CompanyRepository companyRepository;
    @Autowired
    CompanyService companyService;

    @GetMapping("/companies")
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping("/companies/{company_id}")
    public Company getCompany(@PathVariable long company_id){
        return companyService.getCompany(company_id);
    }

    @PostMapping("/companies")
    public Company addCompany(@RequestBody Company company){
        companyService.addCompany(company);
        long savedCompany = company.getId();

        return companyService.getCompany(savedCompany);
    }
}
