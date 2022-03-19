package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Skill;
import edu.miu.cs.cs544.raymond.jobsearch.service.JobService;
import edu.miu.cs.cs544.raymond.jobsearch.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SkillController {
    @Autowired
    private SkillService skillService;

    @Autowired
    JobService jobService;

    @GetMapping(path = "/skills/{skill_id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable long skill_id) {
        Skill foundSkill = skillService.getSkillById(skill_id);
        return ResponseEntity.ok(foundSkill);
    }

    @GetMapping(path = "/skills")
    public ResponseEntity<List<Skill>> getAllSkills() {
        List<Skill> listOfFoundSkills = skillService.getAllSkills();
        return ResponseEntity.ok(listOfFoundSkills);
    }

    @PostMapping(path = "/jobs/{job_id}/skills")
    public ResponseEntity<Skill> addSkill(@PathVariable long job_id, @RequestBody Skill skill) {
        Skill createdSkill = skillService.addSkill(job_id,skill);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdSkill.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .body(createdSkill);
    }

    @PutMapping(path = "/jobs/{job_id}/skills/{skill_id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable long job_id,@PathVariable long skill_id, @RequestBody Skill skillDetails) {
        Skill updatedSkill = skillService.updateSkill(job_id,skill_id, skillDetails);
        return  ResponseEntity.ok(updatedSkill);
    }

    @GetMapping(path = "skills/salary")
    public ResponseEntity<List<Skill>> getSkillsWithSalaryGreaterThan(@RequestParam("amount") double amount) {
        List<Skill> listOfSkillsWithSalaryGreaterThan = skillService.skillsWithJobSalaryGreaterThan(amount);
        return ResponseEntity.ok(listOfSkillsWithSalaryGreaterThan);
    }

    @DeleteMapping(path = "skills/{skill_id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable long skill_id) {
        skillService.getSkillById(skill_id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/jobs/{job_id}/skills")
    public ResponseEntity<List<Skill>> getAllJobSkills(@PathVariable long job_id){
        List<Skill> allJobSkills = jobService.getJob(job_id).getSkills();
        return ResponseEntity.ok(allJobSkills);
    }
}
