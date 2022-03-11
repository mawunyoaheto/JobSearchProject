package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.model.Company;
import edu.miu.cs.cs544.raymond.jobsearch.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping(path="/companies")
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping(path="/companies/{company_id}")
    public Company getCompany(@PathVariable long company_id){
        return companyService.getCompany(company_id);
    }

    @PostMapping(path="/companies")
    public Company addCompany(@RequestBody Company company){
        companyService.addCompany(company);
        long savedCompany = company.getId();
        return companyService.getCompany(savedCompany);
    }

    @PutMapping(path="/companies/{company_id}")
    public void updateCompany(@PathVariable long company_id, @RequestBody Company company){
        companyService.updateCompany(company_id,company);
    }

    @DeleteMapping(path="/companies/{company_id}")
    public ResponseEntity<Void> deleteCompanyById(@PathVariable long company_id){
        companyService.deleteCompany(company_id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
