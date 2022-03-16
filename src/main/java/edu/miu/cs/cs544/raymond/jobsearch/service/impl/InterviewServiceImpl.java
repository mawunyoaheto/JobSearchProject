package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Interview;
import edu.miu.cs.cs544.raymond.jobsearch.repository.InterviewRepository;
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

    @Override
    public Interview getInterviewById(long interview_id) {
        return interviewRepository.getById(interview_id);
    }

    @Override
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    @Override
    public Interview updateInterview(long interview_id, Interview interviewDetails) {
        return interviewRepository.save(interviewDetails);

    }

    @Override
    public Interview addInterview(Interview interview) {
       return interviewRepository.save(interview);
    }

    @Override
    public void deleteInterview(long interview_id) {
        interviewRepository.deleteById(interview_id);
    }
}
