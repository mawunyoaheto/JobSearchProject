package edu.miu.cs.cs544.raymond.jobsearch.repository;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByJob_SalaryGreaterThan(double amount);
}
