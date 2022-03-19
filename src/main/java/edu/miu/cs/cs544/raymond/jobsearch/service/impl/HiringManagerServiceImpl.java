package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.entity.HiringManagerInterview;
import edu.miu.cs.cs544.raymond.jobsearch.entity.Job;
import edu.miu.cs.cs544.raymond.jobsearch.exception.ResourceNotFoundException;
import edu.miu.cs.cs544.raymond.jobsearch.repository.HiringManagerInterviewRepository;
import edu.miu.cs.cs544.raymond.jobsearch.repository.JobRepository;
import edu.miu.cs.cs544.raymond.jobsearch.service.HiringManagerInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HiringManagerServiceImpl implements HiringManagerInterviewService {
    @Autowired
    HiringManagerInterviewRepository hiringManagerInterviewRepository;

    @Autowired
  JobRepository jobRepository;

    @Override
    public HiringManagerInterview getHiringManagerInterviewById(long interview_id) {
        return hiringManagerInterviewRepository.findById(interview_id).orElseThrow(() ->new ResourceNotFoundException("interview with given id not found"));
    }

    @Override
    public List<HiringManagerInterview> getAllHiringManagerInterviews() {
        return hiringManagerInterviewRepository.findAll();
    }

    @Override
    public HiringManagerInterview addHiringManagerInterview(long job_id, HiringManagerInterview hiringManagerInterview) {
        Job foundJob = jobRepository.findById(job_id).orElseThrow(() ->new ResourceNotFoundException("job with given id not found"));
        foundJob.addInterview(hiringManagerInterview);
        hiringManagerInterview.setJob(foundJob);
        return hiringManagerInterviewRepository.save(hiringManagerInterview);
    }

    @Override
    public HiringManagerInterview updateHiringManagerInterview(long interview_id, HiringManagerInterview hiringManagerInterview) {
        hiringManagerInterviewRepository.save(hiringManagerInterview);
        return hiringManagerInterview;
    }

    @Override
    public void deleteHiringManagerInterview(long interview_id) {
        hiringManagerInterviewRepository.deleteById(interview_id);
    }
}
