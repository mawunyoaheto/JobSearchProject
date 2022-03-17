package edu.miu.cs.cs544.raymond.jobsearch.controller;


import edu.miu.cs.cs544.raymond.jobsearch.entity.Company;
import edu.miu.cs.cs544.raymond.jobsearch.entity.Recruiter;
import edu.miu.cs.cs544.raymond.jobsearch.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @GetMapping(path = "/recruiters/{recruiter_id}")
    public ResponseEntity<Company> getRecruiterById(@PathVariable long recruiter_id) {
        Company foundRecruiter = recruiterService.getRecruiterById(recruiter_id);
        return ResponseEntity.ok(foundRecruiter);
    }

    @GetMapping(path = "/recruiters")
    public ResponseEntity<List<Recruiter>> getAllRecruiters() {
        List<Recruiter> foundRecruiters= recruiterService.getAllRecruiters();
        return ResponseEntity.ok(foundRecruiters);
    }

    @PostMapping(path = "/recruiters")
    public ResponseEntity<Recruiter> addRecruiter(@RequestBody Recruiter recruiter) {
        Recruiter createdRecruiter = recruiterService.addRecruiter(recruiter);
        return ResponseEntity.ok(createdRecruiter);
    }

    @PutMapping(path = "/recruiters/{recruiter_id}")
    public ResponseEntity<Recruiter> updateRecruiter(@PathVariable long recruiter_id, @RequestBody Recruiter recruiterDetails) {
       Recruiter updatedRecruiter = recruiterService.updateRecruiter(recruiter_id, recruiterDetails);
       return ResponseEntity.ok(updatedRecruiter);
    }

    @GetMapping(path = "/recruiters/job/")
    public ResponseEntity<List<Recruiter>> getRecruitersWithJobSalaryGreaterThan(@RequestParam("salary") double salary) {
        List<Recruiter> listOfRecruitersWithJobSalary = recruiterService.getRecruitersWithJobPayGreaterThan(salary);
        return ResponseEntity.ok(listOfRecruitersWithJobSalary);
    }

    @DeleteMapping(path = "recruiters/{recruiter_id}")
    public ResponseEntity<Void> deleteRecruiter(@PathVariable long recruiter_id) {
        recruiterService.deleteRecruiter(recruiter_id);
        return ResponseEntity.noContent().build();
    }
}
