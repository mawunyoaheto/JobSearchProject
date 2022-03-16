package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Application;
import edu.miu.cs.cs544.raymond.jobsearch.repository.ApplicationRepository;
import edu.miu.cs.cs544.raymond.jobsearch.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
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
    public void updateApplication(long application_id, Application applicationDetails) {
        applicationRepository.save(applicationDetails);
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
