package edu.miu.cs.cs544.raymond.jobsearch.service.commandlinerunner;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Address;
import edu.miu.cs.cs544.raymond.jobsearch.entity.Company;
import edu.miu.cs.cs544.raymond.jobsearch.entity.Job;
import edu.miu.cs.cs544.raymond.jobsearch.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class JobCommandLinerRunner implements CommandLineRunner {
    @Autowired
    JobService jobService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

       jobService.addJob(new Job("Full Stack Java Developer", 90000.00, new Company("Infotech Systems", new Address("1000N 4th St", "Fairfield", "IA", 52557))));
       jobService.addJob(new Job("Full Stack Java Developer", 120000.00, new Company("Softribe",  new Address("Trump dr", "Davenport", "TX", 46527))));
       jobService.addJob(new Job("Full Stack Javascript Developer", 80000.00, new Company("Microsoft", new Address("One Microsoft Way", "Redmond", "WA", 98052))));
       jobService.addJob(new Job("Full Stack Javascript Developer", 95000.00, new Company("Amazon", new Address("54 State St., Suite 308", "Albany", "NY", 12207))));
       jobService.addJob(new Job("Front-end Developer", 75000.00, new Company("Acenture Systems", new Address("101 North 1st Avenue", "Phoenix", "AZ", 85003))));
       jobService.addJob(new Job("Front-end Developer", 78000.00, new Company("Utopia", new Address("3000S Marcus dr", "Mayfield", "CA", 34673))));
    }
}
