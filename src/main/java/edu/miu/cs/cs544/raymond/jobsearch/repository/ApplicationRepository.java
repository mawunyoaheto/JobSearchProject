package edu.miu.cs.cs544.raymond.jobsearch.repository;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
