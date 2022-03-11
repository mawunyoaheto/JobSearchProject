package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.model.Job;
import edu.miu.cs.cs544.raymond.jobsearch.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class JobController {

//    @Autowired
//    JobRepository jobRepository;

    @Autowired
    JobService jobService;

    @GetMapping("/jobs")
    public List<Job> getAllJobs(){

        return  jobService.getAllJobs();
    }

    @GetMapping("/jobs/{job_id}")
    public Job getJob(@PathVariable long job_id){
        return jobService.getJob(job_id);
    }

    @PostMapping("/jobs")
    public ResponseEntity<Job> addJob(@RequestBody Job job){
        jobService.addJob(job);
        long savedJob = job.getId();
        URI savedJobUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{job_id}")
                .buildAndExpand(savedJob)
                .toUri();
//        return jobService.getJob(savedJob);
        return ResponseEntity.created(savedJobUri).build();
    }
}
