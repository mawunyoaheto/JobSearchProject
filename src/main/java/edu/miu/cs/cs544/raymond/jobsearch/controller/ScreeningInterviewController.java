package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.model.ScreeningInterview;
import edu.miu.cs.cs544.raymond.jobsearch.repository.ScreeningInterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScreeningInterviewController {
    @Autowired
    ScreeningInterviewRepository screeningInterviewRepository;

    @GetMapping("/screeninginterviews/{interview_id}")
    public ScreeningInterview getScreeningInterviewById(@PathVariable long interview_id){
        return  screeningInterviewRepository.getById(interview_id);
    }

    @GetMapping("/screeninginterviews")
    public List<ScreeningInterview> getAllScreeningInterviews(){
        return screeningInterviewRepository.findAll();
    }

    @PostMapping("/screeninginterviews")
    public ScreeningInterview addScreeningInterview(@RequestBody ScreeningInterview screeningInterview){
        screeningInterviewRepository.save(screeningInterview);
        long savedScreeningInterviewId = screeningInterview.getId();
        return screeningInterviewRepository.getById(savedScreeningInterviewId);
    }

    @PutMapping("/screeninginterviews/{interview_id}")
    public void updateScreeningInterview(@PathVariable long interview_id, @RequestBody ScreeningInterview screeningInterview){
        ScreeningInterview interview = screeningInterviewRepository.getById(interview_id);


//                .orElseThrow(()->new ResourceNotFoundEception("Skill not found for this id :: "+skill_id));

    }

    @DeleteMapping("screeninginterviews/{interview_id}")
    public void deleteScreeningInterview(@PathVariable long interview_id){
        screeningInterviewRepository.deleteById(interview_id);
    }
}
