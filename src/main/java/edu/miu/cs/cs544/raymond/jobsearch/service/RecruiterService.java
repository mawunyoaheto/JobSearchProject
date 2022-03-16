package edu.miu.cs.cs544.raymond.jobsearch.service;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Recruiter;

import java.util.List;

public interface RecruiterService {
    public Recruiter getRecruiterById(long recruiter_id);
    public List<Recruiter> getAllRecruiters();
    public Recruiter addRecruiter(Recruiter recruiter);
    public Recruiter updateRecruiter(long recruiter_id, Recruiter recruiterDetails);
    public void deleteRecruiter(long recruiter_id);
    public List<Recruiter> getRecruitersWithJobPayGreaterThan(double amount);
}
