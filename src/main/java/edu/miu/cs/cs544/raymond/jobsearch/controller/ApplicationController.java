package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.model.Application;
import edu.miu.cs.cs544.raymond.jobsearch.model.Company;
import edu.miu.cs.cs544.raymond.jobsearch.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @GetMapping("/applications/{application_id}")
    public Application getApplicationById(@PathVariable long application_id){
        return applicationService.getApplicationById(application_id);
    }

    @GetMapping("/applications")
    public List<Application> getAllApplications(){
        return applicationService.getAllApplications();
    }


    @PutMapping("/applications/{application_id}")
    public void updateApplication(@PathVariable long application_id, @RequestBody Company clientDetails){
        Application application = applicationService.getApplicationById(application_id);
//                .orElseThrow(()->new ResourceNotFoundEception("Skill not found for this id :: "+skill_id));
    }

    @PostMapping("/applications")
    public Application addApplication(@RequestBody Application application){
        applicationService.addApplication(application);
        long savedApplicationId = application.getId();
        return applicationService.getApplicationById(savedApplicationId);
    }

    @DeleteMapping("applications/{application_id}")
    public void deleteApplication(@PathVariable long application_id){
        applicationService.deleteApplication(application_id);
    }
}
