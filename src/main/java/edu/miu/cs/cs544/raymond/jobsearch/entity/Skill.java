package edu.miu.cs.cs544.raymond.jobsearch.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Skill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private int version;
    private String name;
    private int experience;
    private String description;
    private String language;
    @ManyToOne(cascade = CascadeType.ALL)
    private Job job;

    public Skill() {
    }

    public Skill(String name, int experience, String description, String language,Job job) {
        this.name = name;
        this.experience = experience;
        this.description = description;
        this.language = language;
        this.job=job;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

//    public Job getJob() {
//        return job;
//    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", job=" + job +
                '}';
    }
}
