package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.model.Job;
import edu.miu.cs.cs544.raymond.jobsearch.repository.JobRepository;
import edu.miu.cs.cs544.raymond.jobsearch.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class JobServiceImpl implements JobService {

    @Autowired
    JobRepository jobRepository;

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJob(long job_id) {
        return jobRepository.getById(job_id);
    }

    @Override
    public Job addJob(Job job) {
        jobRepository.save(job);
        long savedJob = job.getId();

        return jobRepository.getById(savedJob);
    }

    @Override
    public void updateJob(long job_id, Job jobDetails) {
        Job job = jobRepository.save(jobDetails);
    }

    @Override
    public void deleteJob(long job_id) {
        jobRepository.deleteById(job_id);
    }
}
