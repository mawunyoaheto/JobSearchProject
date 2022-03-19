package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Company;
import edu.miu.cs.cs544.raymond.jobsearch.entity.Job;
import edu.miu.cs.cs544.raymond.jobsearch.exception.ResourceNotFoundException;
import edu.miu.cs.cs544.raymond.jobsearch.jms.Sender;
import edu.miu.cs.cs544.raymond.jobsearch.repository.CompanyRepository;
import edu.miu.cs.cs544.raymond.jobsearch.repository.JobRepository;
import edu.miu.cs.cs544.raymond.jobsearch.service.CompanyService;
import edu.miu.cs.cs544.raymond.jobsearch.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class JobServiceImpl implements JobService {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    CompanyService companyService;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    Sender sender;

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJob(long job_id) {
        return jobRepository.findById(job_id).orElseThrow(() ->new ResourceNotFoundException("job with given id not found"));
    }

    @Override
    public Job addJob(long company_id, Job job) throws JMSException {
        Company foundCompany = companyService.getCompany(company_id).orElseThrow(() ->new ResourceNotFoundException("company with given id not found"));
        Job createdJob = sender.send(job);
        foundCompany.addJob(createdJob);
        createdJob.setCompany(foundCompany);
        return jobRepository.save(createdJob);
    }



    @Override
    public Job updateJob(long company_id, long job_id, Job jobDetails) {
        Company foundCompany = companyService.getCompany(company_id).orElseThrow(() ->new ResourceNotFoundException("company with given id not found"));
        Job updatedJob = jobRepository.findById(job_id).orElseThrow(() ->new ResourceNotFoundException("job with given id not found"));
//        updatedJob.setCompany(jobDetails.getCompany());
        updatedJob.setCompany(foundCompany);
        return jobRepository.save(updatedJob);
    }

    @Override
    public void deleteJob(long job_id) {
        jobRepository.deleteById(job_id);
    }

    @Override
    public List<Job> findJobBySate(String state) {
       return jobRepository.findJobBySate(state);
//        return jobRepository.findByCompany_Address_State(state);
    }

    @Override
    public List<Job> getAllJobsWithApplication() {
        return jobRepository.getAllJobsWithApplication();
    }


}
