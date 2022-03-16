package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.entity.HiringManagerInterview;
import edu.miu.cs.cs544.raymond.jobsearch.service.HiringManagerInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/hiringmanagerinterviews")
    public ResponseEntity<HiringManagerInterview> addHiringManagerInterview(@RequestBody HiringManagerInterview hiringManagerInterview) {
       HiringManagerInterview createdHiringManagerInterview= hiringManagerInterviewService.addHiringManagerInterview(hiringManagerInterview);
        return ResponseEntity.ok(createdHiringManagerInterview);
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
