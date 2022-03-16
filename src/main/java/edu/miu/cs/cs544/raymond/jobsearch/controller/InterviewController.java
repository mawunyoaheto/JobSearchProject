package edu.miu.cs.cs544.raymond.jobsearch.controller;


import edu.miu.cs.cs544.raymond.jobsearch.entity.Interview;
import edu.miu.cs.cs544.raymond.jobsearch.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InterviewController {
    @Autowired
    private InterviewService interviewService;

    @GetMapping(path = "/interviews/{interview_id}")
    public ResponseEntity<Interview> getInterviewById(@PathVariable long interview_id) {
        Interview foundInterview = interviewService.getInterviewById(interview_id);
        return ResponseEntity.ok(foundInterview);
    }

    @GetMapping(path = "/interviews")
    public ResponseEntity<List<Interview>> getAllInterviews() {
        List<Interview> foundInterviews = interviewService.getAllInterviews();
        return ResponseEntity.ok(foundInterviews);
    }

    @PostMapping(path = "/interviews")
    public ResponseEntity<Interview> addInterview(@RequestBody Interview interview) {
        Interview createdInterview = interviewService.addInterview(interview);
        return ResponseEntity.ok(createdInterview);
    }


    @PutMapping(path = "/interviews/{interview_id}")
    public ResponseEntity<Interview> updateInterview(@PathVariable long interview_id, @RequestBody Interview interviewDetails) {
        Interview updatedInterview = interviewService.updateInterview(interview_id, interviewDetails);
        return ResponseEntity.ok(updatedInterview);
    }

    @DeleteMapping(path = "interviews/{interview_id}")
    public ResponseEntity<Void> deleteInterview(@PathVariable long interview_id) {
        interviewService.deleteInterview(interview_id);
        return ResponseEntity.noContent().build();
    }


}
