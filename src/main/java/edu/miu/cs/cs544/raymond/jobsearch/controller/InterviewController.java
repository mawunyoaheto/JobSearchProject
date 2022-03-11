package edu.miu.cs.cs544.raymond.jobsearch.controller;


import edu.miu.cs.cs544.raymond.jobsearch.model.Interview;
import edu.miu.cs.cs544.raymond.jobsearch.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InterviewController {
    @Autowired
    InterviewService interviewService;

    @GetMapping(path = "/interviews/{interview_id}")
    public Interview getInterviewById(@PathVariable long interview_id) {
        return interviewService.getInterviewById(interview_id);
    }

    @GetMapping(path = "/interviews")
    public List<Interview> getAllInterviews() {
        return interviewService.getAllInterviews();
    }


    @PutMapping(path = "/interviews/{interview_id}")
    public void updateInterview(@PathVariable long interview_id, @RequestBody Interview interviewDetails) {
        interviewService.updateInterview(interview_id, interviewDetails);
    }

    @PostMapping(path = "/interviews")
    public Interview addInterview(@RequestBody Interview interview) {
        interviewService.addInterview(interview);
        long savedInterviewId = interview.getId();
        return interviewService.getInterviewById(savedInterviewId);
    }

    @DeleteMapping(path = "interviews/{interview_id}")
    public void deleteInterview(@PathVariable long interview_id) {
        interviewService.deleteInterview(interview_id);
    }


}
