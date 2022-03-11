package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.model.HiringManagerInterview;
import edu.miu.cs.cs544.raymond.jobsearch.repository.HiringManagerInterviewRepository;
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

    @Override
    public HiringManagerInterview getHiringManagerInterviewById(long interview_id) {
        return hiringManagerInterviewRepository.getById(interview_id);
    }

    @Override
    public List<HiringManagerInterview> getAllHiringManagerInterviews() {
        return hiringManagerInterviewRepository.findAll();
    }

    @Override
    public HiringManagerInterview addHiringManagerInterview(HiringManagerInterview hiringManagerInterview) {
        hiringManagerInterviewRepository.save(hiringManagerInterview);
        long savedHiringManagerId = hiringManagerInterview.getId();
        return hiringManagerInterviewRepository.getById(savedHiringManagerId);
    }

    @Override
    public void updateHiringManagerInterview(long interview_id, HiringManagerInterview hiringManagerInterview) {
        hiringManagerInterviewRepository.save(hiringManagerInterview);
    }

    @Override
    public void deleteHiringManagerInterview(long interview_id) {
        hiringManagerInterviewRepository.deleteById(interview_id);
    }
}
