package edu.miu.cs.cs544.raymond.jobsearch.service;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Skill;

import java.util.List;

public interface SkillService {

    public Skill getSkillById(long skill_id);
    public List<Skill> getAllSkills();
    public Skill addSkill(Skill skill);
    public Skill updateSkill(long skill_id, Skill skillDetails);
    public void deleteSkill(long skill_id);
    public List<Skill> skillsWithJobSalaryGreaterThan(double amount);
}
