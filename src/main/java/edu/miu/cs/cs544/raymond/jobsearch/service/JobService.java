package edu.miu.cs.cs544.raymond.jobsearch.service;

import edu.miu.cs.cs544.raymond.jobsearch.model.Job;

import java.util.List;

public interface JobService {

    public List<Job> getAllJobs();
    public Job getJob(long job_id);
    public Job addJob(Job job);
    public void updateJob(long job_id, Job jobDetails);
    public void deleteJob(long skill_id);
}
