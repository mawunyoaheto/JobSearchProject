package edu.miu.cs.cs544.raymond.jobsearch.service;

import edu.miu.cs.cs544.raymond.jobsearch.model.TechnicalInterview;

import java.util.List;

public interface TechnicalInterviewService {

    public TechnicalInterview getTechnicalInterviewById(long interview_id);
    public List<TechnicalInterview> getAllTechnicalInterviews();
    public TechnicalInterview addTechnicalInterview(TechnicalInterview technicalInterview);
    public void updateTechnicalInterview(long interview_id, TechnicalInterview technicalInterview);
    public void deleteTechnicalInterview(long interview_id);
}
