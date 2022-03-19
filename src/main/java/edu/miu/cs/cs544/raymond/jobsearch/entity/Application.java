package edu.miu.cs.cs544.raymond.jobsearch.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Version
    private int version;
    private LocalDate date;
    private String resume_version;
    @OneToOne(mappedBy = "application",cascade = CascadeType.ALL)
    private Job job;


    public Application() {
    }

    public Application(LocalDate date, String resume_version) {
        this.date = date;
        this.resume_version = resume_version;
    }

    public Application(LocalDate date, String resume_version, Job job) {
        this.date = date;
        this.resume_version = resume_version;
        setJob(job);
    }

    public Long getId() {
        return id;
    }


//    public Job getJob() {
//        return job;
//    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getResume_version() {
        return resume_version;
    }

    public void setResume_version(String resume_version) {
        this.resume_version = resume_version;
    }

    public void setJob(Job job) {

        this.job=job;
//        if(job!=null){
//            this.job = job;
//            this.job.setApplication(this);
//        }

    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", version=" + version +
                ", date=" + date +
                ", resume_version='" + resume_version + '\'' +
                ", job=" + job +
                '}';
    }
}
