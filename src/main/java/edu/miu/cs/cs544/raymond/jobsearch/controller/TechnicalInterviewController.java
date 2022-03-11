package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.model.TechnicalInterview;
import edu.miu.cs.cs544.raymond.jobsearch.repository.TechnicalInterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TechnicalInterviewController {

    @Autowired
    TechnicalInterviewRepository technicalInterviewRepository;

    @GetMapping("/technicalinterviews/{interview_id}")
    public TechnicalInterview getTechnicalInterviewById(@PathVariable long interview_id){
        return  technicalInterviewRepository.getById(interview_id);
    }

    @GetMapping("/technicalinterviews")
    public List<TechnicalInterview> getAllTechnicalInterviews(){
        return technicalInterviewRepository.findAll();
    }

    @PostMapping("/technicalinterviews")
    public TechnicalInterview addTechnicalInterview(@RequestBody TechnicalInterview technicalInterview){
        technicalInterviewRepository.save(technicalInterview);
        long savedTechnicalInterviewId = technicalInterview.getId();
        return technicalInterviewRepository.getById(savedTechnicalInterviewId);
    }

    @PutMapping("/technicalinterviews/{interview_id}")
    public void updateTechnicalInterview(@PathVariable long interview_id, @RequestBody TechnicalInterview technicalInterview){
        TechnicalInterview interview = technicalInterviewRepository.getById(interview_id);
//                .orElseThrow(()->new ResourceNotFoundEception("Skill not found for this id :: "+skill_id));

    }

    @DeleteMapping("technicalinterviews/{interview_id}")
    public void deleteTechnicalInterview(@PathVariable long interview_id){
        technicalInterviewRepository.deleteById(interview_id);
    }
}
