package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Job;
import edu.miu.cs.cs544.raymond.jobsearch.entity.Skill;
import edu.miu.cs.cs544.raymond.jobsearch.exception.ResourceNotFoundException;
import edu.miu.cs.cs544.raymond.jobsearch.repository.JobRepository;
import edu.miu.cs.cs544.raymond.jobsearch.repository.SkillRepository;
import edu.miu.cs.cs544.raymond.jobsearch.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SkillsServiceImpl implements SkillService {
    @Autowired
    SkillRepository skillRepository;

    @Autowired
    JobRepository jobRepository;

    @Override
    public Skill getSkillById(long skill_id) {
        return skillRepository.getById(skill_id);
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Skill addSkill(long job_id, Skill skill) {
        Job foundJob = jobRepository.findById(job_id).orElseThrow(() ->new ResourceNotFoundException("job with given id not found"));
        skill.setJob(foundJob);
        foundJob.addSkill(skill);
       return skillRepository.save(skill);
    }

    @Override
    public Skill updateSkill(long job_id, long skill_id, Skill skillDetails) {
        Job foundJob = jobRepository.findById(job_id).orElseThrow(() ->new ResourceNotFoundException("job with given id not found"));
        Skill foundSkill = skillRepository.findById(skill_id).orElseThrow();
        foundSkill=skillDetails;
        foundSkill.setJob(foundJob);
        return  skillRepository.save(skillDetails);
    }

    @Override
    public void deleteSkill(long skill_id) {
        skillRepository.deleteById(skill_id);
    }

    @Override
    public List<Skill> skillsWithJobSalaryGreaterThan(double amount) {
        List<Skill> skillsWithJob= skillRepository.findByJob_SalaryGreaterThan(amount);
        if(skillsWithJob!=null){
            return skillsWithJob;
        }else throw(new ResourceNotFoundException("job with given id not found"));
    }
}
