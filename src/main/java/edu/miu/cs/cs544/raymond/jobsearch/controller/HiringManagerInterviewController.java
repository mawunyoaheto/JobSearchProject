package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.model.HiringManagerInterview;
import edu.miu.cs.cs544.raymond.jobsearch.repository.HiringManagerInterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HiringManagerInterviewController {


    @Autowired
    HiringManagerInterviewRepository hiringManagerInterviewRepository;

    @GetMapping("/hiringmanagerinterviews/{interview_id}")
    public HiringManagerInterview getHiringManagerInterviewById(@PathVariable long interview_id){
        return  hiringManagerInterviewRepository.getById(interview_id);
    }

    @GetMapping("/hiringmanagerinterviews")
    public List<HiringManagerInterview> getAllHiringManagerInterviews(){
        return hiringManagerInterviewRepository.findAll();
    }

    @PostMapping("/hiringmanagerinterviews")
    public HiringManagerInterview addHiringManagerInterview(@RequestBody HiringManagerInterview hiringManagerInterview){
        hiringManagerInterviewRepository.save(hiringManagerInterview);
        long savedHiringManagerId = hiringManagerInterview.getId();
        return hiringManagerInterviewRepository.getById(savedHiringManagerId);
    }

    @PutMapping("/hiringmanagerinterviews/{interview_id}")
    public void updateHiringManagerInterview(@PathVariable long interview_id, @RequestBody HiringManagerInterview hiringManagerInterview){
        HiringManagerInterview interview = hiringManagerInterviewRepository.getById(interview_id);


//                .orElseThrow(()->new ResourceNotFoundEception("Skill not found for this id :: "+skill_id));

    }

    @DeleteMapping("hiringmanagerinterviews/{interview_id}")
    public void deleteHiringManagerInterview(@PathVariable long interview_id){
        hiringManagerInterviewRepository.deleteById(interview_id);
    }
}
