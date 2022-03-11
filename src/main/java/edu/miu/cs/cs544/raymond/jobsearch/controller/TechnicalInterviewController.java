package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.model.TechnicalInterview;
import edu.miu.cs.cs544.raymond.jobsearch.service.TechnicalInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TechnicalInterviewController {

    @Autowired
    TechnicalInterviewService technicalInterviewService;

    @GetMapping(path = "/technicalinterviews/{interview_id}")
    public TechnicalInterview getTechnicalInterviewById(@PathVariable long interview_id) {
        return technicalInterviewService.getTechnicalInterviewById(interview_id);
    }

    @GetMapping(path = "/technicalinterviews")
    public List<TechnicalInterview> getAllTechnicalInterviews() {
        return technicalInterviewService.getAllTechnicalInterviews();
    }

    @PostMapping(path = "/technicalinterviews")
    public TechnicalInterview addTechnicalInterview(@RequestBody TechnicalInterview technicalInterview) {
        technicalInterviewService.addTechnicalInterview(technicalInterview);
        long savedTechnicalInterviewId = technicalInterview.getId();
        return technicalInterviewService.getTechnicalInterviewById(savedTechnicalInterviewId);
    }

    @PutMapping(path = "/technicalinterviews/{interview_id}")
    public void updateTechnicalInterview(@PathVariable long interview_id, @RequestBody TechnicalInterview technicalInterview) {
        technicalInterviewService.updateTechnicalInterview(interview_id, technicalInterview);
    }

    @DeleteMapping(path = "technicalinterviews/{interview_id}")
    public void deleteTechnicalInterview(@PathVariable long interview_id) {
        technicalInterviewService.deleteTechnicalInterview(interview_id);
    }
}
