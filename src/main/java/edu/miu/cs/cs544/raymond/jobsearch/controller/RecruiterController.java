package edu.miu.cs.cs544.raymond.jobsearch.controller;


import edu.miu.cs.cs544.raymond.jobsearch.model.Company;
import edu.miu.cs.cs544.raymond.jobsearch.model.Recruiter;
import edu.miu.cs.cs544.raymond.jobsearch.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecruiterController {

    @Autowired
    RecruiterService recruiterService;

    @GetMapping("/recruiters/{recruiter_id}")
    public Company getRecruiterById(@PathVariable long recruiter_id){
        return  recruiterService.getRecruiterById(recruiter_id);
    }

    @GetMapping("/recruiters")
    public List<Recruiter> getAllRecruiters(){
        return recruiterService.getAllRecruiters();
    }

    @PostMapping("/recruiters")
    public Company addRecruiter(@RequestBody Recruiter recruiter){
        recruiterService.addRecruiter(recruiter);
        long savedRecruiterId = recruiter.getId();
        return recruiterService.getRecruiterById(savedRecruiterId);
    }

    @PutMapping("/recruiters/{recruiter_id}")
    public void updateRecruiter(@PathVariable long recruiter_id, @RequestBody Company recruiterDetails){
        Company recruiter = recruiterService.getRecruiterById(recruiter_id);
//                .orElseThrow(()->new ResourceNotFoundEception("Skill not found for this id :: "+skill_id));
    }

    @DeleteMapping("recruiters/{recruiter_id}")
    public void deleteRecruiter(@PathVariable long recruiter_id){
        recruiterService.deleteRecruiter(recruiter_id);
    }
}
