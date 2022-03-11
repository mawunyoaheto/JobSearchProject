package edu.miu.cs.cs544.raymond.jobsearch.controller;


import edu.miu.cs.cs544.raymond.jobsearch.model.Interview;
import edu.miu.cs.cs544.raymond.jobsearch.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InterviewController {
    @Autowired
    InterviewRepository interviewRepository;

    @GetMapping("/interviews/{interview_id}")
    public Interview getInterviewById(@PathVariable long interview_id){
        return interviewRepository.getById(interview_id);
    }

    @GetMapping("/interviews")
    public List<Interview> getAllInterviews(){
        return interviewRepository.findAll();
    }


    @PutMapping("/interviews/{interview_id}")
    public void updateInterview(@PathVariable long interview_id, @RequestBody Interview interviewDetails){
        Interview interview = interviewRepository.getById(interview_id);
//                .orElseThrow(()->new ResourceNotFoundEception("Skill not found for this id :: "+skill_id));
    }

    @PostMapping("/interviews")
    public Interview addInterview(@RequestBody Interview interview){
        interviewRepository.save(interview);
        long savedInterviewId = interview.getId();
        return interviewRepository.getById(savedInterviewId);
    }

    @DeleteMapping("interviews/{interview_id}")
    public void deleteInterview(@PathVariable long interview_id){
        interviewRepository.deleteById(interview_id);
    }


}
