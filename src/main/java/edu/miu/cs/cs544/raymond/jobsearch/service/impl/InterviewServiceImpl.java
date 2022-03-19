package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Interview;
import edu.miu.cs.cs544.raymond.jobsearch.entity.Job;
import edu.miu.cs.cs544.raymond.jobsearch.exception.ResourceNotFoundException;
import edu.miu.cs.cs544.raymond.jobsearch.repository.InterviewRepository;
import edu.miu.cs.cs544.raymond.jobsearch.repository.JobRepository;
import edu.miu.cs.cs544.raymond.jobsearch.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InterviewServiceImpl implements InterviewService {
    @Autowired
    InterviewRepository interviewRepository;

    @Autowired
    JobRepository jobRepository;

    @Override
    public Interview getInterviewById(long interview_id) {
        return interviewRepository.getById(interview_id);
    }

    @Override
    public List<Interview> getAllInterviewsByJob(long job_id) {
       Job foundJob = jobRepository.findById(job_id).orElseThrow(()->new ResourceNotFoundException("job with given id not found"));
       return foundJob.getInterviews();
    }

    @Override
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }


    @Override
    public void deleteInterview(long interview_id) {
        interviewRepository.deleteById(interview_id);
    }
}
