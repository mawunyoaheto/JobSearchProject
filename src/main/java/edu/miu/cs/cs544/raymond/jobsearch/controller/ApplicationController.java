package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.model.Application;
import edu.miu.cs.cs544.raymond.jobsearch.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @GetMapping(path="/applications/{application_id}")
    public Application getApplicationById(@PathVariable long application_id){
        return applicationService.getApplicationById(application_id);
    }

    @GetMapping(path="/applications")
    public List<Application> getAllApplications(){
        return applicationService.getAllApplications();
    }


    @PutMapping(path="/applications/{application_id}")
    public void updateApplication(@PathVariable long application_id, @RequestBody Application application){
     applicationService.updateApplication(application_id,application);
    }

    @PostMapping(path="/applications")
    public Application addApplication(@RequestBody Application application){
        applicationService.addApplication(application);
        long savedApplicationId = application.getId();
        return applicationService.getApplicationById(savedApplicationId);
    }

    @DeleteMapping(path="applications/{application_id}")
    public void deleteApplication(@PathVariable long application_id){
        applicationService.deleteApplication(application_id);
    }
}
