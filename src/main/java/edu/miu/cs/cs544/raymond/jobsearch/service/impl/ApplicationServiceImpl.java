package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Application;
import edu.miu.cs.cs544.raymond.jobsearch.entity.Job;
import edu.miu.cs.cs544.raymond.jobsearch.exception.ResourceNotFoundException;
import edu.miu.cs.cs544.raymond.jobsearch.repository.ApplicationRepository;
import edu.miu.cs.cs544.raymond.jobsearch.repository.JobRepository;
import edu.miu.cs.cs544.raymond.jobsearch.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    JobRepository jobRepository;

    @Override
    public Application getApplicationById(long application_id) {
        return applicationRepository.findById(application_id).orElseThrow(
                () ->new ResourceNotFoundException("application with given id not found"));
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public void updateApplication(long application_id, Application applicationDetails) {
        applicationRepository.save(applicationDetails);
    }

    @Override
    public Application addApplication(long job_id, Application application) {
        Job foundJob = jobRepository.findById(job_id).orElseThrow(() ->new ResourceNotFoundException("job with given id not found"));
        foundJob.setApplication(application);
        application.setJob(foundJob);
       return applicationRepository.save(application);
    }

    @Override
    public void deleteApplication(long application_id) {
        applicationRepository.deleteById(application_id);
    }
}
