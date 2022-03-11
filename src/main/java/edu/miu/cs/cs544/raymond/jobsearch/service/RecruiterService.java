package edu.miu.cs.cs544.raymond.jobsearch.service;

import edu.miu.cs.cs544.raymond.jobsearch.model.Company;
import edu.miu.cs.cs544.raymond.jobsearch.model.Recruiter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RecruiterService {
    public Company getRecruiterById(long recruiter_id);
    public List<Recruiter> getAllRecruiters();
    public Company addRecruiter(@RequestBody Recruiter recruiter);
    public void updateRecruiter(@PathVariable long recruiter_id, @RequestBody Company recruiterDetails);
    public void deleteRecruiter(@PathVariable long recruiter_id);
}
