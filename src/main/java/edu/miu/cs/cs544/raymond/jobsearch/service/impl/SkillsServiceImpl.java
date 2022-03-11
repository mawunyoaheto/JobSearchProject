package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.model.Skill;
import edu.miu.cs.cs544.raymond.jobsearch.repository.SkillRepository;
import edu.miu.cs.cs544.raymond.jobsearch.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsServiceImpl implements SkillService {
    @Autowired
    SkillRepository skillRepository;

    @Override
    public Skill getSkillById(long skill_id) {
        return skillRepository.getById(skill_id);
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Skill addSkill(Skill skill) {
        skillRepository.save(skill);
        long savedKills = skill.getId();
        return skillRepository.getById(savedKills);
    }

    @Override
    public void updateSkill(long skill_id, Skill skillDetails) {
        Skill skill = skillRepository.getById(skill_id);
//                .orElseThrow(()->new ResourceNotFoundEception("Skill not found for this id :: "+skill_id));
    }

    @Override
    public void deleteSkill(long skill_id) {
        skillRepository.deleteById(skill_id);
    }
}
