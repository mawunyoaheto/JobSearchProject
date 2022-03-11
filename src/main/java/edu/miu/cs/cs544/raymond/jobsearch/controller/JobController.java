package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.model.Job;
import edu.miu.cs.cs544.raymond.jobsearch.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping(path="/jobs")
    public ResponseEntity<List<Job>> getAllJobs(){
        List<Job> listOfAllJobs = jobService.getAllJobs();
        return new ResponseEntity<List<Job>>(listOfAllJobs, HttpStatus.OK);
    }

    @GetMapping(path="/jobs/{job_id}")
    public Job getJob(@PathVariable long job_id){
        return jobService.getJob(job_id);
    }

    @PostMapping(path="/jobs")
    public void addJob(@RequestBody Job job){
        jobService.addJob(job);
    }

    @PutMapping(path = "/jobs/{job_id}")
    public void updateJob(@PathVariable long job_id, Job job){
        jobService.updateJob(job_id,job);
    }

    @DeleteMapping(path="/jobs/{job_id}")
    public ResponseEntity<Void> deleteJobById(@PathVariable long job_id){
        jobService.deleteJob(job_id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
