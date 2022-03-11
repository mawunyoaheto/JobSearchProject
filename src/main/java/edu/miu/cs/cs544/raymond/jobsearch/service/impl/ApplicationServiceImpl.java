package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.model.Application;
import edu.miu.cs.cs544.raymond.jobsearch.model.Company;
import edu.miu.cs.cs544.raymond.jobsearch.repository.ApplicationRepository;
import edu.miu.cs.cs544.raymond.jobsearch.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;

    @Override
    public Application getApplicationById(long application_id) {
        return applicationRepository.getById(application_id);
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public void updateApplication(long application_id, Company clientDetails) {
        Application application = applicationRepository.getById(application_id);
//                .orElseThrow(()->new ResourceNotFoundEception("Skill not found for this id :: "+skill_id));
    }

    @Override
    public Application addApplication(Application application) {
        applicationRepository.save(application);
        long savedApplicationId = application.getId();
        return applicationRepository.getById(savedApplicationId);
    }

    @Override
    public void deleteApplication(long application_id) {
        applicationRepository.deleteById(application_id);
    }
}
