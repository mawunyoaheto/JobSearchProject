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

    @GetMapping(path = "/screeninginterviews/{interview_id}")
    public ScreeningInterview getScreeningInterviewById(@PathVariable long interview_id) {
        return screeningInterviewService.getScreeningInterviewById(interview_id);
    }

    @GetMapping(path = "/screeninginterviews")
    public List<ScreeningInterview> getAllScreeningInterviews() {
        return screeningInterviewService.getAllScreeningInterviews();
    }

    @PostMapping(path = "/screeninginterviews")
    public ScreeningInterview addScreeningInterview(@RequestBody ScreeningInterview screeningInterview) {
        screeningInterviewService.addScreeningInterview(screeningInterview);
        long savedScreeningInterviewId = screeningInterview.getId();
        return screeningInterviewService.getScreeningInterviewById(savedScreeningInterviewId);
    }

    @PutMapping(path = "/screeninginterviews/{interview_id}")
    public void updateScreeningInterview(@PathVariable long interview_id, @RequestBody ScreeningInterview screeningInterview) {
        screeningInterviewService.updateScreeningInterview(interview_id, screeningInterview);
    }

    @DeleteMapping(path = "screeninginterviews/{interview_id}")
    public void deleteScreeningInterview(@PathVariable long interview_id) {
        screeningInterviewService.deleteScreeningInterview(interview_id);
    }
}
