package edu.miu.cs.cs544.raymond.jobsearch.service;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Job;

import javax.jms.JMSException;
import java.util.List;

public interface JobService {

    public List<Job> getAllJobs();
    public Job getJob(long job_id);
    public Job addJob(long company_id, Job job) throws JMSException;
    public Job updateJob(long company_id, long job_id, Job jobDetails);
    public void deleteJob(long job_id);
    public List<Job> findJobBySate(String state);
    public List<Job> getAllJobsWithApplication();
}
