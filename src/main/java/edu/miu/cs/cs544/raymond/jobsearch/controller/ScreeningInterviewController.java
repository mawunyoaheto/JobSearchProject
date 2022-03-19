package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.entity.ScreeningInterview;
import edu.miu.cs.cs544.raymond.jobsearch.service.ScreeningInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ScreeningInterviewController {
    @Autowired
    private ScreeningInterviewService screeningInterviewService;

    @GetMapping(path = "/screeninginterviews/{interview_id}")
    public ResponseEntity<ScreeningInterview> getScreeningInterviewById(@PathVariable long interview_id) {
        ScreeningInterview foundScreeningInterview = screeningInterviewService.getScreeningInterviewById(interview_id);
        return ResponseEntity.ok(foundScreeningInterview);
    }

    @GetMapping(path = "/screeninginterviews")
    public ResponseEntity<List<ScreeningInterview>> getAllScreeningInterviews() {
        List<ScreeningInterview> foundScreeningInterviews = screeningInterviewService.getAllScreeningInterviews();
        return ResponseEntity.ok(foundScreeningInterviews);
    }

    @PostMapping(path = "/jobs/{job_id}/screeninginterviews")
    public ResponseEntity<ScreeningInterview> addScreeningInterview(@PathVariable long job_id,@RequestBody ScreeningInterview screeningInterview) {
        ScreeningInterview createdTechnicalInterview =  screeningInterviewService.addScreeningInterview(job_id,screeningInterview);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTechnicalInterview.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .body(createdTechnicalInterview);
    }

    @PutMapping(path = "/screeninginterviews/{interview_id}")
    public ResponseEntity<ScreeningInterview> updateScreeningInterview(@PathVariable long interview_id, @RequestBody ScreeningInterview screeningInterview) {
        ScreeningInterview updatedScreeningInterview =screeningInterviewService.updateScreeningInterview(interview_id, screeningInterview);
        return ResponseEntity.ok(screeningInterview);
    }

    @DeleteMapping(path = "screeninginterviews/{interview_id}")
    public ResponseEntity<Void> deleteScreeningInterview(@PathVariable long interview_id) {
        screeningInterviewService.deleteScreeningInterview(interview_id);
        return ResponseEntity.noContent().build();
    }
}
