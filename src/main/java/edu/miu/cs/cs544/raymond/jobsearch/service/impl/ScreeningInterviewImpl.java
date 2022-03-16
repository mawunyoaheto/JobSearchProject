package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.entity.ScreeningInterview;
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

    @Override
    public ScreeningInterview getScreeningInterviewById(long interview_id) {
        return  screeningInterviewRepository.getById(interview_id);
    }

    @Override
    public List<ScreeningInterview> getAllScreeningInterviews() {
        return screeningInterviewRepository.findAll();
    }

    @Override
    public ScreeningInterview addScreeningInterview(ScreeningInterview screeningInterview) {
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
