package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.model.Interview;
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
    public void updateInterview(long interview_id, Interview interviewDetails) {
        interviewRepository.save(interviewDetails);
    }

    @Override
    public Interview addInterview(Interview interview) {
        interviewRepository.save(interview);
        long savedInterviewId = interview.getId();
        return interviewRepository.getById(savedInterviewId);
    }

    @Override
    public void deleteInterview(long interview_id) {
        interviewRepository.deleteById(interview_id);
    }
}
