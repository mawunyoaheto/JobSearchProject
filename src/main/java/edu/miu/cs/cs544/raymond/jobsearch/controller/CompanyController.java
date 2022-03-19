package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Company;
import edu.miu.cs.cs544.raymond.jobsearch.service.CompanyService;
import edu.miu.cs.cs544.raymond.jobsearch.service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyServiceImpl companyServiceImp ;

    @GetMapping(path="/companies")
    public ResponseEntity<List<Company>> getAllCompanies(){
        List<Company> foundCompanies = companyService.getAllCompanies();
        return ResponseEntity.ok(foundCompanies);
    }

    @GetMapping(path="/companies/{company_id}")
    public Company getCompany(@PathVariable long company_id){
//        return ResponseEntity.of(companyService.getCompany(company_id));
        return companyServiceImp.getOneCompany(company_id);
    }

    @PostMapping(path="/companies")
    public ResponseEntity<Company> addCompany(@RequestBody Company company){
        Company createdCompany = companyService.addCompany(company);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdCompany.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .body(createdCompany);
    }

    @PutMapping(path="/companies/{company_id}")
    public ResponseEntity<Company> updateCompany(@PathVariable long company_id, @RequestBody Company company){
       Company updateCompany = companyService.updateCompany(company_id,company);
       return ResponseEntity.ok(updateCompany);
    }
 @DeleteMapping(path="/companies/{company_id}")
    public ResponseEntity<Void> deleteCompanyById(@PathVariable long company_id){
        companyService.deleteCompany(company_id);
         return ResponseEntity.noContent().build();
    }
}
