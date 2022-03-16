package edu.miu.cs.cs544.raymond.jobsearch.repository;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository <Job, Long> {

    @Query("SELECT j FROM Job j WHERE j.company.address.state =:state")
    List<Job> findJobBySate(String state);

    List<Job> findByCompany_Address_State(String state);

    @Query(value = "select * from job j inner join application a  ON j.APPLICATION_ID=a.ID", nativeQuery = true)
    List<Job> getAllJobsWithApplication();
}