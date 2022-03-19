package edu.miu.cs.cs544.raymond.jobsearch.controller;


import edu.miu.cs.cs544.raymond.jobsearch.entity.Interview;
import edu.miu.cs.cs544.raymond.jobsearch.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.ok(interviewService.getAllInterviews());
    }

    @GetMapping(path = "/jobs/{job_id}/interviews")
    public ResponseEntity<List<Interview>> getInterviewsByJobId(@PathVariable long job_id) {
     return ResponseEntity.ok(interviewService.getAllInterviewsByJob(job_id));
    }


    @DeleteMapping(path = "interviews/{interview_id}")
    public ResponseEntity<Void> deleteInterview(@PathVariable long interview_id) {
        interviewService.deleteInterview(interview_id);
        return ResponseEntity.noContent().build();
    }


}
