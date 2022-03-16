package edu.miu.cs.cs544.raymond.jobsearch.service;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Interview;

import java.util.List;

public interface InterviewService {
    public Interview getInterviewById(long interview_id);
    public List<Interview> getAllInterviews();
    public Interview updateInterview(long interview_id, Interview interviewDetails);
    public Interview addInterview(Interview interview);
    public void deleteInterview(long interview_id);
}
