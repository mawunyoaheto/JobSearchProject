package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Job;
import edu.miu.cs.cs544.raymond.jobsearch.jms.Sender;
import edu.miu.cs.cs544.raymond.jobsearch.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;
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
       return ResponseEntity.ok(jobService.getJob(job_id));

    }

    @PostMapping(path="/companies/{company_id}/jobs")
    public Job addJob(@PathVariable long company_id, @RequestBody Job job) throws JMSException {
        return jobService.addJob(company_id,job);
    }

    @PutMapping(path = "/companies/{company_id}/jobs/{job_id}")
    public ResponseEntity<Job> updateJob(@PathVariable long company_id, @PathVariable long job_id, Job job) {
            return ResponseEntity.ok(jobService.updateJob(company_id,job_id, job));
    }

    @GetMapping(path = "/jobs/state")
    public ResponseEntity<List<Job>> getJobsByState(@RequestParam("state") String state) {
        return ResponseEntity.ok(jobService.findJobBySate(state));
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
