package edu.miu.cs.cs544.raymond.jobsearch.service;

import edu.miu.cs.cs544.raymond.jobsearch.model.ScreeningInterview;

import java.util.List;

public interface ScreeningInterviewService {

    public ScreeningInterview getScreeningInterviewById(long interview_id);
    public List<ScreeningInterview> getAllScreeningInterviews();
    public ScreeningInterview addScreeningInterview(ScreeningInterview screeningInterview);
    public void updateScreeningInterview(long interview_id, ScreeningInterview screeningInterview);
    public void deleteScreeningInterview(long interview_id);
}
