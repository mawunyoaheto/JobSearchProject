package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Job;
import edu.miu.cs.cs544.raymond.jobsearch.entity.TechnicalInterview;
import edu.miu.cs.cs544.raymond.jobsearch.exception.ResourceNotFoundException;
import edu.miu.cs.cs544.raymond.jobsearch.repository.JobRepository;
import edu.miu.cs.cs544.raymond.jobsearch.repository.TechnicalInterviewRepository;
import edu.miu.cs.cs544.raymond.jobsearch.service.TechnicalInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TechnicalInterviewImpl implements TechnicalInterviewService {
    @Autowired
    private TechnicalInterviewRepository technicalInterviewRepository;

    @Autowired
    JobRepository jobRepository;

    @Override
    public TechnicalInterview getTechnicalInterviewById(long interview_id) {
        return  technicalInterviewRepository.getById(interview_id);
    }

    @Override
    public List<TechnicalInterview> getAllTechnicalInterviews() {
        return technicalInterviewRepository.findAll();
    }

    @Override
    public TechnicalInterview addTechnicalInterview(long job_id, TechnicalInterview technicalInterview) {
       Job foundJob = jobRepository.findById(job_id).orElseThrow(() ->new ResourceNotFoundException("Job with given id not found"));
       foundJob.addInterview(technicalInterview);
       technicalInterview.setJob(foundJob);
        return technicalInterviewRepository.save(technicalInterview);
    }

    @Override
    public TechnicalInterview updateTechnicalInterview(long interview_id, TechnicalInterview technicalInterview) {
        technicalInterviewRepository.save(technicalInterview);
        return technicalInterview;
    }

    @Override
    public void deleteTechnicalInterview(long interview_id) {
        technicalInterviewRepository.deleteById(interview_id);
    }
}
