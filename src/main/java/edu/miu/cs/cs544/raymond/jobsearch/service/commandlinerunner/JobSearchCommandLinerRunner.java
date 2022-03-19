package edu.miu.cs.cs544.raymond.jobsearch.service.commandlinerunner;

import edu.miu.cs.cs544.raymond.jobsearch.entity.*;
import edu.miu.cs.cs544.raymond.jobsearch.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JobSearchCommandLinerRunner implements CommandLineRunner {
    @Autowired
    JobRepository jobRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        List<Job> infotech_jobs = new ArrayList<>();
        List<Job> amazon_jobs = new ArrayList<>();
        List<Job> jobs3 = new ArrayList<>();
        List<Client> recruiterClients = new ArrayList<>();
        Job javascript_developer = new Job("Full Stack Javascript Developer", 95000.00f);
        Job front_end_dev = new Job("Front-end Developer", 75000.00f);
        Job java_dev = new Job("Full Stack Java Developer", 95000.00f);
        Job j4 = new Job("Front-end Developer", 78000.00f);
        infotech_jobs.add(javascript_developer);
        infotech_jobs.add(front_end_dev);
        amazon_jobs.add(java_dev);
        jobs3.add(j4);

        Company infotech = new Company("Infotech Systems", new Address("1000N 4th St", "Fairfield", "IA", 52557), infotech_jobs);
        Client amazon = new Client("Amazon", new Address("54 State St., Suite 308", "Albany", "NY", 12207), amazon_jobs, "Serve consumers through online and physical stores ", "focus on selection, price, and convenience", "www.amazon.com");
        recruiterClients.add(amazon);
        Recruiter kforce = new Recruiter("K-Force", new Address("14542 Harley dr", "Desmoine", "IA", 23452),recruiterClients);
        kforce.setClients(recruiterClients);

        Application a1 = new Application(LocalDate.of(2022, 3, 30), "Solutions Architect Version");
        Application a2 = new Application(LocalDate.of(2022, 4, 1), "Software Architect Version");

        a1.setJob(javascript_developer);
        a2.setJob(front_end_dev);
        List<Skill> skillList1 = new ArrayList<Skill>();
        skillList1.add(new Skill("Back-End", 3, "Excellent ", "Javascript", javascript_developer));
        skillList1.add(new Skill("Front-End", 3, "Fair ", "Angular", javascript_developer));
        List<Skill> skillList2 = new ArrayList<Skill>();
        skillList2.add(new Skill("Front-End", 4, "Excellent ", "React", front_end_dev));
        skillList2.add(new Skill("Full Stack Developer", 3, "architecture setup", "C#", front_end_dev));
        List<Skill> skillList3 = new ArrayList<Skill>();
        skillList3.add(new Skill("system design", 3, "large systems design", "JAVA", java_dev));
        skillList3.add(new Skill("system architecture", 3, "architecture setup", "C#", java_dev));
        List<Skill> skillList4 = new ArrayList<Skill>();
        skillList4.add(new Skill("system design", 3, "large systems design", "JAVA", j4));
        skillList4.add(new Skill("Dev Ops", 10, "AWS Associate", "C#", j4));
        javascript_developer.setCompany(infotech);
        front_end_dev.setCompany(infotech);
        java_dev.setCompany(amazon);
        javascript_developer.setApplication(a1);
        front_end_dev.setApplication(a2);
        //j3.setApplication(a2);
        //j4.setApplication(a2);
        javascript_developer.setSkills(skillList1);
        front_end_dev.setSkills(skillList2);
        java_dev.setSkills(skillList3);
        j4.setSkills(skillList4);

        List<Interview> javascript_dev_interviews = new ArrayList<>();
        Interview interview1 = new ScreeningInterview(LocalDate.of(2022, 02, 27), "+16147017379", "rmkaheto@gmail.com", "Raymond", "Success");
        Interview interview2 = new TechnicalInterview(LocalDate.of(2022, 02, 27), "+16147017379", "rmkaheto@gmail.com", 30, "How many Years of experience do u have", Location.ONLINE);
        Interview interview3 = new HiringManagerInterview(LocalDate.of(2022, 03, 30), "+16147017379", "rmkaheto@gmail.com", 15, LocalDate.of(2022, 04, 15));
        javascript_dev_interviews.add(interview1);
        javascript_dev_interviews.add(interview2);
        javascript_dev_interviews.add(interview3);

        List<Interview> front_end_dev_interviews = new ArrayList<>();
        Interview interview4 = new ScreeningInterview(LocalDate.of(2022, 03, 10), "+16147017379", "rmkaheto@gmail.com", "Raymond", "Success");
        Interview interview5 = new TechnicalInterview(LocalDate.of(2022, 03, 13), "+16147017379", "rmkaheto@gmail.com", 15, "What is your weakness?", Location.ONLINE);
        Interview interview6 = new HiringManagerInterview(LocalDate.of(2022, 03, 17), "+16147017379", "rmkaheto@gmail.com", 80, LocalDate.of(2022, 04, 15));
        front_end_dev_interviews.add(interview4);
        front_end_dev_interviews.add(interview5);
        front_end_dev_interviews.add(interview6);

        javascript_developer.setInterviews(javascript_dev_interviews);
        front_end_dev.setInterviews(front_end_dev_interviews);

        jobRepository.save(javascript_developer);
        jobRepository.save(front_end_dev);
        jobRepository.save(java_dev);
        jobRepository.save(j4);
    }
}
