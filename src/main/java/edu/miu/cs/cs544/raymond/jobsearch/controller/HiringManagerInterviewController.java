package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.model.HiringManagerInterview;
import edu.miu.cs.cs544.raymond.jobsearch.service.HiringManagerInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HiringManagerInterviewController {

    @Autowired
    HiringManagerInterviewService hiringManagerInterviewService;

    @GetMapping("/hiringmanagerinterviews/{interview_id}")
    public HiringManagerInterview getHiringManagerInterviewById(@PathVariable long interview_id){
        return  hiringManagerInterviewService.getHiringManagerInterviewById(interview_id);
    }

    @GetMapping("/hiringmanagerinterviews")
    public List<HiringManagerInterview> getAllHiringManagerInterviews(){
        return hiringManagerInterviewService.getAllHiringManagerInterviews();
    }

    @PostMapping("/hiringmanagerinterviews")
    public HiringManagerInterview addHiringManagerInterview(@RequestBody HiringManagerInterview hiringManagerInterview){
        hiringManagerInterviewService.addHiringManagerInterview(hiringManagerInterview);
        long savedHiringManagerId = hiringManagerInterview.getId();
        return hiringManagerInterviewService.getHiringManagerInterviewById(savedHiringManagerId);
    }

    @PutMapping("/hiringmanagerinterviews/{interview_id}")
    public void updateHiringManagerInterview(@PathVariable long interview_id, @RequestBody HiringManagerInterview hiringManagerInterview){
        HiringManagerInterview interview = hiringManagerInterviewService.getHiringManagerInterviewById(interview_id);
//                .orElseThrow(()->new ResourceNotFoundEception("Skill not found for this id :: "+skill_id));
    }

    @DeleteMapping("hiringmanagerinterviews/{interview_id}")
    public void deleteHiringManagerInterview(@PathVariable long interview_id){
       hiringManagerInterviewService.deleteHiringManagerInterview(interview_id);
    }
}
