package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.model.Skill;
import edu.miu.cs.cs544.raymond.jobsearch.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkillController {
    @Autowired
    SkillRepository skillRepository;

    @GetMapping("/skills/{skill_id}")
    public Skill getSkillById(@PathVariable long skill_id){
        return skillRepository.getById(skill_id);
    }

    @GetMapping("/skills")
    public List<Skill> getAllSkills(){

        return skillRepository.findAll();
    }

    @PostMapping("/skills")
    public Skill addSkill(@RequestBody Skill skill){
        skillRepository.save(skill);

        long savedKills  = skill.getId();
        return skillRepository.getById(savedKills);
    }

    @PutMapping("/skills/{skill_id}")
    public void updateSkill(@PathVariable long skill_id, @RequestBody Skill skillDetails){
        Skill skill = skillRepository.getById(skill_id);


//                .orElseThrow(()->new ResourceNotFoundEception("Skill not found for this id :: "+skill_id));

    }

    @DeleteMapping("skills/{skill_id}")
    public void deleteSkill(@PathVariable long skill_id){
        skillRepository.deleteById(skill_id);
    }
}
