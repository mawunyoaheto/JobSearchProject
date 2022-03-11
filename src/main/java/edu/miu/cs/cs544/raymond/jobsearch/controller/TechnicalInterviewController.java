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

    @GetMapping("/technicalinterviews/{interview_id}")
    public TechnicalInterview getTechnicalInterviewById(@PathVariable long interview_id){
        return  technicalInterviewService.getTechnicalInterviewById(interview_id);
    }

    @GetMapping("/technicalinterviews")
    public List<TechnicalInterview> getAllTechnicalInterviews(){
        return technicalInterviewService.getAllTechnicalInterviews();
    }

    @PostMapping("/technicalinterviews")
    public TechnicalInterview addTechnicalInterview(@RequestBody TechnicalInterview technicalInterview){
        technicalInterviewService.addTechnicalInterview(technicalInterview);
        long savedTechnicalInterviewId = technicalInterview.getId();
        return technicalInterviewService.getTechnicalInterviewById(savedTechnicalInterviewId);
    }

    @PutMapping("/technicalinterviews/{interview_id}")
    public void updateTechnicalInterview(@PathVariable long interview_id, @RequestBody TechnicalInterview technicalInterview){
        TechnicalInterview interview = technicalInterviewService.getTechnicalInterviewById(interview_id);
//                .orElseThrow(()->new ResourceNotFoundEception("Skill not found for this id :: "+skill_id));
    }

    @DeleteMapping("technicalinterviews/{interview_id}")
    public void deleteTechnicalInterview(@PathVariable long interview_id){
        technicalInterviewService.deleteTechnicalInterview(interview_id);
    }
}
