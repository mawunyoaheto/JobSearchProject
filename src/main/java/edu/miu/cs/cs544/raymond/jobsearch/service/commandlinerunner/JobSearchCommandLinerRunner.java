package edu.miu.cs.cs544.raymond.jobsearch.service.commandlinerunner;

import edu.miu.cs.cs544.raymond.jobsearch.entity.*;
import edu.miu.cs.cs544.raymond.jobsearch.service.CompanyService;
import edu.miu.cs.cs544.raymond.jobsearch.service.JobService;
import edu.miu.cs.cs544.raymond.jobsearch.service.RecruiterService;
import edu.miu.cs.cs544.raymond.jobsearch.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class JobSearchCommandLinerRunner implements CommandLineRunner {
    @Autowired
    JobService jobService;

    @Autowired
    SkillService skillService;

    @Autowired
    RecruiterService recruiterService;

    @Autowired
    CompanyService companyService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Company infotech = companyService.addCompany(new Company("Infotech Systems", new Address("1000N 4th St", "Fairfield", "IA", 52557)));
        Company softribe = companyService.addCompany(new Company("Softribe", new Address("Trump dr", "Davenport", "TX", 46527)));
        Company microsoft = companyService.addCompany(new Company("Microsoft", new Address("One Microsoft Way", "Redmond", "WA", 98052)));
        Company amazon = companyService.addCompany(new Company("Amazon", new Address("54 State St., Suite 308", "Albany", "NY", 12207)));
        Company acenture =companyService.addCompany(new Company("Acenture Systems", new Address("101 North 1st Avenue", "Phoenix", "AZ", 85003)));
        Company utopia = companyService.addCompany(new Company("Utopia", new Address("3000S Marcus dr", "Mayfield", "CA", 34673)));
        Recruiter kforce = recruiterService.addRecruiter(new Recruiter("K-Force", new Address("14542 Harley dr", "Desmoine", "IA", 23452)));

        Skill infotechAngularSkill = skillService.addSkill(new Skill("Front-End", 3, "Fair ", "Angular"));
        Skill infotechJavaSkill = skillService.addSkill(new Skill("Back-End", 5, "Excellent ", "Java"));
        Job infotechJob = jobService.addJob(new Job("Full Stack Java Developer", 90000.00, infotech));
        infotechJob.setSkills(infotechJavaSkill);
        infotechJob.setSkills(infotechAngularSkill);

        Skill softribeJavaSkill = skillService.addSkill(new Skill("Back-End", 3, "Excellent ", "Java"));
        Skill softribeReactSkill = skillService.addSkill(new Skill("Front-End", 3, "Excellent ", "React"));
        Job softribeJob = jobService.addJob(new Job("Full Stack Java Developer", 120000.00, softribe));
        softribeJob.setSkills(softribeReactSkill);
        softribeJob.setSkills(softribeJavaSkill);

        Skill microsoftDotnetSkill = skillService.addSkill(new Skill("Back-End", 10, "Excellent ", "Dotnet"));
        Skill microsoftAngularSkill = skillService.addSkill(new Skill("Front-End", 3, "Fair ", "Angular"));
        Skill microsoftReactSkill = skillService.addSkill(new Skill("Front-End", 3, "Excellent ", "React"));
        Job microsoftJob = jobService.addJob(new Job("Full Stack Javascript Developer", 80000.00, microsoft));
        microsoftJob.setSkills(microsoftAngularSkill);
        microsoftJob.setSkills(microsoftReactSkill);
        microsoftJob.setSkills(microsoftDotnetSkill);

        Skill amazonJavascriptSkill = skillService.addSkill(new Skill("Back-End", 3, "Excellent ", "Javascript"));
        Skill amazonAngularSkill = skillService.addSkill(new Skill("Front-End", 3, "Fair ", "Angular"));
        Job amazonJob = jobService.addJob(new Job("Full Stack Javascript Developer", 95000.00, amazon));
        amazonJob.setSkills(amazonAngularSkill);
        amazonJob.setSkills(amazonJavascriptSkill);

        Skill acentureReactSkill = skillService.addSkill(new Skill("Front-End", 4, "Excellent ", "React"));
        Job acentureJob = jobService.addJob(new Job("Front-end Developer", 75000.00, acenture));
        acentureJob.setSkills(acentureReactSkill);

        Skill utopiaAngularSkill = skillService.addSkill(new Skill("Front-End", 2, "Fair ", "Angular"));
        Job utopiaJob = jobService.addJob(new Job("Front-end Developer", 78000.00, utopia));
        utopiaJob.setSkills(utopiaAngularSkill);


    }
}
