package edu.miu.cs.cs544.raymond.jobsearch.repository;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Client;
import edu.miu.cs.cs544.raymond.jobsearch.entity.Job;
import edu.miu.cs.cs544.raymond.jobsearch.entity.Recruiter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class RecruiterSpecification {
    public static Specification<Recruiter> hasSalaryGreaterThan(double amount){
        return new Specification<Recruiter>() {
            @Override
            public Predicate toPredicate(Root<Recruiter> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Join<Recruiter, Client> joinClients = root.join("company");
                Join<Client, Job> joinJobs = joinClients.join("company");
                return criteriaBuilder.greaterThan(joinJobs.get("salary"), amount);
            }
        };
    }


    public static Specification<Recruiter> hasSalGreaterThan(double amount){
        return (root, query, criteriaBuilder)->{
            Join<Recruiter, Client> joinClients = root.join("company");
            Join<Client, Job> joinJobs = joinClients.join("company");
            return criteriaBuilder.greaterThan(joinJobs.get("salary"), amount);
        };
    }
}
