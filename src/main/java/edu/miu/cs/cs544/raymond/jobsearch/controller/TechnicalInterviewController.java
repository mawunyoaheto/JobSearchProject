package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.entity.TechnicalInterview;
import edu.miu.cs.cs544.raymond.jobsearch.service.TechnicalInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class TechnicalInterviewController {

    @Autowired
    private TechnicalInterviewService technicalInterviewService;

    @GetMapping(path = "/technicalinterviews/{interview_id}")
    public ResponseEntity<TechnicalInterview> getTechnicalInterviewById(@PathVariable long interview_id) {
        TechnicalInterview foundTechnicalInterview = technicalInterviewService.getTechnicalInterviewById(interview_id);
        return ResponseEntity.ok(foundTechnicalInterview);
    }

    @GetMapping(path = "/technicalinterviews")
    public ResponseEntity<List<TechnicalInterview>> getAllTechnicalInterviews() {
        List<TechnicalInterview> listOfFoundTechnicalInterview = technicalInterviewService.getAllTechnicalInterviews();
        return ResponseEntity.ok(listOfFoundTechnicalInterview);
    }

    @PostMapping(path = "/jobs/{job_id}/technicalinterviews")
    public ResponseEntity<TechnicalInterview> addTechnicalInterview(@PathVariable long job_id, @RequestBody TechnicalInterview technicalInterview) {
       TechnicalInterview createdTechnicalInterview = technicalInterviewService.addTechnicalInterview(job_id,technicalInterview);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTechnicalInterview.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .body(createdTechnicalInterview);
    }

    @PutMapping(path = "/technicalinterviews/{interview_id}")
    public ResponseEntity<TechnicalInterview> updateTechnicalInterview(@PathVariable long interview_id, @RequestBody TechnicalInterview technicalInterview) {
        TechnicalInterview updatedTechnicalInterview = technicalInterviewService.updateTechnicalInterview(interview_id, technicalInterview);
        return ResponseEntity.ok(updatedTechnicalInterview);
    }

    @DeleteMapping(path = "technicalinterviews/{interview_id}")
    public ResponseEntity<Void> deleteTechnicalInterview(@PathVariable long interview_id) {
        technicalInterviewService.deleteTechnicalInterview(interview_id);
        return ResponseEntity.noContent().build();
    }
}
