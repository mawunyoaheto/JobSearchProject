package edu.miu.cs.cs544.raymond.jobsearch.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Application {
    @Id
    @GeneratedValue
    private  Long id;
    @Version
    private int version;
    private LocalDate date;
    private int resume_version;
    @OneToOne(mappedBy = "application",cascade = CascadeType.PERSIST)
    private Job job;


    public Application() {
    }

    public Application(LocalDate date, int resume_version) {
        this.date = date;
        this.resume_version = resume_version;
    }

    public Application(LocalDate date, int resume_version, Job job) {
        this.date = date;
        this.resume_version = resume_version;
        setJob(job);
    }

    public long getId() {
        return id;
    }


    public Job getJob() {
        return job;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getResume_version() {
        return resume_version;
    }

    public void setResume_version(int resume_version) {
        this.resume_version = resume_version;
    }

    public void setJob(Job job) {
        if(job!=null){
            this.job = job;
            this.job.setApplication(this);
        }

    }
}
