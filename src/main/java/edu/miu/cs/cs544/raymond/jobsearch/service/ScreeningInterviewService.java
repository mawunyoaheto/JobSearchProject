package edu.miu.cs.cs544.raymond.jobsearch.service;

import edu.miu.cs.cs544.raymond.jobsearch.entity.ScreeningInterview;

import java.util.List;

public interface ScreeningInterviewService {

    public ScreeningInterview getScreeningInterviewById(long interview_id);
    public List<ScreeningInterview> getAllScreeningInterviews();
    public ScreeningInterview addScreeningInterview(long job_id, ScreeningInterview screeningInterview);
    public ScreeningInterview updateScreeningInterview(long interview_id, ScreeningInterview screeningInterview);
    public void deleteScreeningInterview(long interview_id);
}
