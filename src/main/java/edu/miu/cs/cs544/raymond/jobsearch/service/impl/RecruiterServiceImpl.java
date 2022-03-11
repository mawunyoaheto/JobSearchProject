package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.model.Recruiter;
import edu.miu.cs.cs544.raymond.jobsearch.repository.RecruiterRepository;
import edu.miu.cs.cs544.raymond.jobsearch.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RecruiterServiceImpl implements RecruiterService {
    @Autowired
    RecruiterRepository recruiterRepository;

    @Override
    public Recruiter getRecruiterById(long recruiter_id) {
        return recruiterRepository.getById(recruiter_id);
    }

    @Override
    public List<Recruiter> getAllRecruiters() {
        return recruiterRepository.findAll();
    }

    @Override
    public Recruiter addRecruiter(Recruiter recruiter) {
        recruiterRepository.save(recruiter);
        long savedRecruiterId = recruiter.getId();
        return recruiterRepository.getById(savedRecruiterId);
    }

    @Override
    public void updateRecruiter(long recruiter_id, Recruiter recruiterDetails) {
       recruiterRepository.save(recruiterDetails);
    }

    @Override
    public void deleteRecruiter(long recruiter_id) {
        recruiterRepository.deleteById(recruiter_id);
    }
}
