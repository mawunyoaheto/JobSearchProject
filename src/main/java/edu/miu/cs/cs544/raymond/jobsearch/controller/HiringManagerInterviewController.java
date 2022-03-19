package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.entity.HiringManagerInterview;
import edu.miu.cs.cs544.raymond.jobsearch.service.HiringManagerInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class HiringManagerInterviewController {

    @Autowired
    private HiringManagerInterviewService hiringManagerInterviewService;

    @GetMapping(path = "/hiringmanagerinterviews/{interview_id}")
    public ResponseEntity<HiringManagerInterview> getHiringManagerInterviewById(@PathVariable long interview_id) {
       HiringManagerInterview foundHiringManagerInterview = hiringManagerInterviewService.getHiringManagerInterviewById(interview_id);
        return ResponseEntity.ok(foundHiringManagerInterview);
    }

    @GetMapping(path = "/hiringmanagerinterviews")
    public ResponseEntity<List<HiringManagerInterview>> getAllHiringManagerInterviews() {
        List<HiringManagerInterview> foundHiringManagerInterviews= hiringManagerInterviewService.getAllHiringManagerInterviews();
        return ResponseEntity.ok(foundHiringManagerInterviews);
    }

    @PostMapping(path = "/jobs/{job_id}/hiringmanagerinterviews")
    public ResponseEntity<HiringManagerInterview> addHiringManagerInterview(@PathVariable long job_id, @RequestBody HiringManagerInterview hiringManagerInterview) {
        HiringManagerInterview createdHiringInterview = hiringManagerInterviewService.addHiringManagerInterview(job_id,hiringManagerInterview);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdHiringInterview.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .body(createdHiringInterview);
    }

    @PutMapping(path = "/hiringmanagerinterviews/{interview_id}")
    public ResponseEntity<HiringManagerInterview> updateHiringManagerInterview(@PathVariable long interview_id, @RequestBody HiringManagerInterview hiringManagerInterview) {
        HiringManagerInterview updatedHiringManagerInterview = hiringManagerInterviewService.updateHiringManagerInterview(interview_id, hiringManagerInterview);
        return ResponseEntity.ok(updatedHiringManagerInterview);
    }

    @DeleteMapping(path = "hiringmanagerinterviews/{interview_id}")
    public ResponseEntity<Void> deleteHiringManagerInterview(@PathVariable long interview_id) {
        hiringManagerInterviewService.deleteHiringManagerInterview(interview_id);
        return ResponseEntity.noContent().build();
    }
}
