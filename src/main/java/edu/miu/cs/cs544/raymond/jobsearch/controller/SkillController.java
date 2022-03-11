package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.model.Skill;
import edu.miu.cs.cs544.raymond.jobsearch.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkillController {
    @Autowired
    SkillService skillService;

    @GetMapping("/skills/{skill_id}")
    public Skill getSkillById(@PathVariable long skill_id) {
        return skillService.getSkillById(skill_id);
    }

    @GetMapping("/skills")
    public List<Skill> getAllSkills() {

        return skillService.getAllSkills();
    }

    @PostMapping("/skills")
    public Skill addSkill(@RequestBody Skill skill) {
        skillService.addSkill(skill);
        long savedKills = skill.getId();
        return skillService.getSkillById(savedKills);
    }

    @PutMapping("/skills/{skill_id}")
    public void updateSkill(@PathVariable long skill_id, @RequestBody Skill skillDetails) {
        Skill skill = skillService.getSkillById(skill_id);
//                .orElseThrow(()->new ResourceNotFoundEception("Skill not found for this id :: "+skill_id));
    }

    @DeleteMapping("skills/{skill_id}")
    public void deleteSkill(@PathVariable long skill_id) {
        skillService.getSkillById(skill_id);
    }
}
