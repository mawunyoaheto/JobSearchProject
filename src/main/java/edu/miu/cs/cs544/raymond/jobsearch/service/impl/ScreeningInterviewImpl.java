package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Job;
import edu.miu.cs.cs544.raymond.jobsearch.entity.ScreeningInterview;
import edu.miu.cs.cs544.raymond.jobsearch.exception.ResourceNotFoundException;
import edu.miu.cs.cs544.raymond.jobsearch.repository.JobRepository;
import edu.miu.cs.cs544.raymond.jobsearch.repository.ScreeningInterviewRepository;
import edu.miu.cs.cs544.raymond.jobsearch.service.ScreeningInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScreeningInterviewImpl implements ScreeningInterviewService {

    @Autowired
    ScreeningInterviewRepository screeningInterviewRepository;

    @Autowired
    JobRepository jobRepository;

    @Override
    public ScreeningInterview getScreeningInterviewById(long interview_id) {
        return  screeningInterviewRepository.getById(interview_id);
    }

    @Override
    public List<ScreeningInterview> getAllScreeningInterviews() {
        return screeningInterviewRepository.findAll();
    }

    @Override
    public ScreeningInterview addScreeningInterview(long job_id, ScreeningInterview screeningInterview) {
        Job foundJob = jobRepository.findById(job_id).orElseThrow(() ->new ResourceNotFoundException("Job with given id not found"));
        foundJob.addInterview(screeningInterview);
        screeningInterview.setJob(foundJob);
        return screeningInterviewRepository.save(screeningInterview);
    }

    @Override
    public ScreeningInterview updateScreeningInterview(long interview_id, ScreeningInterview screeningInterview) {
        ScreeningInterview interview = screeningInterviewRepository.getById(interview_id);
        return interview;
    }

    @Override
    public void deleteScreeningInterview(long interview_id) {
        screeningInterviewRepository.deleteById(interview_id);
    }
}
