package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.model.ScreeningInterview;
import edu.miu.cs.cs544.raymond.jobsearch.service.ScreeningInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScreeningInterviewController {
    @Autowired
    ScreeningInterviewService screeningInterviewService;

    @GetMapping("/screeninginterviews/{interview_id}")
    public ScreeningInterview getScreeningInterviewById(@PathVariable long interview_id){
        return  screeningInterviewService.getScreeningInterviewById(interview_id);
    }

    @GetMapping("/screeninginterviews")
    public List<ScreeningInterview> getAllScreeningInterviews(){
        return screeningInterviewService.getAllScreeningInterviews();
    }

    @PostMapping("/screeninginterviews")
    public ScreeningInterview addScreeningInterview(@RequestBody ScreeningInterview screeningInterview){
        screeningInterviewService.addScreeningInterview(screeningInterview);
        long savedScreeningInterviewId = screeningInterview.getId();
        return screeningInterviewService.getScreeningInterviewById(savedScreeningInterviewId);
    }

    @PutMapping("/screeninginterviews/{interview_id}")
    public void updateScreeningInterview(@PathVariable long interview_id, @RequestBody ScreeningInterview screeningInterview){
        ScreeningInterview interview = screeningInterviewService.getScreeningInterviewById(interview_id);
//                .orElseThrow(()->new ResourceNotFoundEception("Skill not found for this id :: "+skill_id));
    }

    @DeleteMapping("screeninginterviews/{interview_id}")
    public void deleteScreeningInterview(@PathVariable long interview_id){
        screeningInterviewService.deleteScreeningInterview(interview_id);
    }
}
