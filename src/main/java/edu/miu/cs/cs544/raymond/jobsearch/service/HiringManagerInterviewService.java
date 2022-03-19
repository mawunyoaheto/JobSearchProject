package edu.miu.cs.cs544.raymond.jobsearch.service;

import edu.miu.cs.cs544.raymond.jobsearch.entity.HiringManagerInterview;

import java.util.List;

public interface HiringManagerInterviewService {

    public HiringManagerInterview getHiringManagerInterviewById(long interview_id);
    public List<HiringManagerInterview> getAllHiringManagerInterviews();
    public HiringManagerInterview addHiringManagerInterview(long job_id,HiringManagerInterview hiringManagerInterview);
    public HiringManagerInterview updateHiringManagerInterview(long interview_id, HiringManagerInterview hiringManagerInterview);
    public void deleteHiringManagerInterview(long interview_id);
}
