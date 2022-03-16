package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.entity.TechnicalInterview;
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
    @Override
    public TechnicalInterview getTechnicalInterviewById(long interview_id) {
        return  technicalInterviewRepository.getById(interview_id);
    }

    @Override
    public List<TechnicalInterview> getAllTechnicalInterviews() {
        return technicalInterviewRepository.findAll();
    }

    @Override
    public TechnicalInterview addTechnicalInterview(TechnicalInterview technicalInterview) {
        technicalInterviewRepository.save(technicalInterview);
        long savedTechnicalInterviewId = technicalInterview.getId();
        return technicalInterviewRepository.getById(savedTechnicalInterviewId);
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
