package edu.miu.cs.cs544.raymond.jobsearch.service;

import edu.miu.cs.cs544.raymond.jobsearch.model.Application;

import java.util.List;

public interface ApplicationService {
    public Application getApplicationById(long application_id);
    public List<Application> getAllApplications();
    public void updateApplication(long application_id, Application applicationDetails);
    public Application addApplication(Application application);
    public void deleteApplication(long application_id);
}
