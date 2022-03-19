package edu.miu.cs.cs544.raymond.jobsearch.service;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Interview;

import java.util.List;

public interface InterviewService {
    public Interview getInterviewById(long interview_id);
    public List<Interview> getAllInterviewsByJob( long job_id);
    public List<Interview> getAllInterviews();
    public void deleteInterview(long interview_id);
}
