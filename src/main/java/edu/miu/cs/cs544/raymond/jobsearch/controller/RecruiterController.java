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

    @GetMapping(path = "/recruiters/{recruiter_id}")
    public Company getRecruiterById(@PathVariable long recruiter_id) {
        return recruiterService.getRecruiterById(recruiter_id);
    }

    @GetMapping(path = "/recruiters")
    public List<Recruiter> getAllRecruiters() {
        return recruiterService.getAllRecruiters();
    }

    @PostMapping(path = "/recruiters")
    public Recruiter addRecruiter(@RequestBody Recruiter recruiter) {
        recruiterService.addRecruiter(recruiter);
        long savedRecruiterId = recruiter.getId();
        return recruiterService.getRecruiterById(savedRecruiterId);
    }

    @PutMapping(path = "/recruiters/{recruiter_id}")
    public void updateRecruiter(@PathVariable long recruiter_id, @RequestBody Recruiter recruiterDetails) {
        recruiterService.updateRecruiter(recruiter_id, recruiterDetails);
    }

    @DeleteMapping(path = "recruiters/{recruiter_id}")
    public void deleteRecruiter(@PathVariable long recruiter_id) {
        recruiterService.deleteRecruiter(recruiter_id);
    }
}
