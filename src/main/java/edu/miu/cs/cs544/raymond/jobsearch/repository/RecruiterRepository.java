package edu.miu.cs.cs544.raymond.jobsearch.repository;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long>, JpaSpecificationExecutor<Recruiter> {

//    List<Recruiter> findJobsWithSalaryGreaterThan(double amount);

}
