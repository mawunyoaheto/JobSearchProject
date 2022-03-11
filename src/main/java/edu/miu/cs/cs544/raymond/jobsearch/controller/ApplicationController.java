package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.model.Application;
import edu.miu.cs.cs544.raymond.jobsearch.model.Company;
import edu.miu.cs.cs544.raymond.jobsearch.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    ApplicationRepository applicationRepository;

    @GetMapping("/applications/{application_id}")
    public Application getApplicationById(@PathVariable long application_id){
        return applicationRepository.getById(application_id);
    }

    @GetMapping("/applications")
    public List<Application> getAllApplications(){
        return applicationRepository.findAll();
    }


    @PutMapping("/applications/{application_id}")
    public void updateApplication(@PathVariable long application_id, @RequestBody Company clientDetails){
        Application application = applicationRepository.getById(application_id);
//                .orElseThrow(()->new ResourceNotFoundEception("Skill not found for this id :: "+skill_id));
    }

    @PostMapping("/applications")
    public Application addApplication(@RequestBody Application application){
        applicationRepository.save(application);
        long savedApplicationId = application.getId();
        return applicationRepository.getById(savedApplicationId);
    }

    @DeleteMapping("applications/{application_id}")
    public void deleteApplication(@PathVariable long application_id){
        applicationRepository.deleteById(application_id);
    }
}
