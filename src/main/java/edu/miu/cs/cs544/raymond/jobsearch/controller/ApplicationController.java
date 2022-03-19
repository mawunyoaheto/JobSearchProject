package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Application;
import edu.miu.cs.cs544.raymond.jobsearch.service.ApplicationService;
import edu.miu.cs.cs544.raymond.jobsearch.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private JobService jobService;

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

    @PostMapping(path="/jobs/{job_id}/applications")
    public Application addApplication(@PathVariable long job_id, @RequestBody Application application){
        return applicationService.addApplication(job_id,application);
    }

    @DeleteMapping(path="applications/{application_id}")
    public void deleteApplication(@PathVariable long application_id){
        applicationService.deleteApplication(application_id);
    }
    @GetMapping(path = "/jobs/{job_id}/application")
    public ResponseEntity<Application> getJobApplication(@PathVariable long job_id){
        Application foundApplication = jobService.getJob(job_id).getApplication();
        return ResponseEntity.ok(foundApplication);
    }
}
