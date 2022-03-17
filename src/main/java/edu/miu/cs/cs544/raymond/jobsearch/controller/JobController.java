package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Job;
import edu.miu.cs.cs544.raymond.jobsearch.jms.Sender;
import edu.miu.cs.cs544.raymond.jobsearch.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private Sender sender;

    @GetMapping(path="/jobs")
    public ResponseEntity<List<Job>> getAllJobs(){
        List<Job> listOfAllJobs = jobService.getAllJobs();
        return ResponseEntity.ok(listOfAllJobs);
    }

    @GetMapping(path="/jobs/{job_id}")
    public ResponseEntity<Job> getJob(@PathVariable long job_id){

        Job foundJob = jobService.getJob(job_id);

       return ResponseEntity.ok(foundJob);

    }

    @PostMapping(path="/jobs")
    public void addJob(@RequestBody Job job){
        sender.send(job);

    }

    @PutMapping(path = "/jobs/{job_id}")
    public ResponseEntity<Job> updateJob(@PathVariable long job_id, Job job) {
        Job updatedJob = jobService.updateJob(job_id, job);
//        if (updatedJob == null) {
//            return ResponseEntity.notFound().build();
//        } else {
            return ResponseEntity.ok(updatedJob);
//        }
    }

    @GetMapping(path = "/jobs/state")
    public ResponseEntity<List<Job>> getJobsByState(@RequestParam("state") String state) {
        List<Job> listOfSateJobs = jobService.findJobBySate(state);
        return ResponseEntity.ok(listOfSateJobs);
    }

    @GetMapping(path = "/jobs/applications")
    public ResponseEntity<List<Job>> getAllJobsWithApplication(){
        List<Job> listOfAllJobsWithApplication = jobService.getAllJobsWithApplication();
        return ResponseEntity.ok(listOfAllJobsWithApplication);
    }

    @DeleteMapping(path="/jobs/{job_id}")
    public ResponseEntity<Object> deleteJobById(@PathVariable long job_id){
        jobService.deleteJob(job_id);
        return ResponseEntity.noContent().build();
    }
}
