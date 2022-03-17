package edu.miu.cs.cs544.raymond.jobsearch.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "job")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Job implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Version
    private int version;
    private String title;
    private Double salary;
    @OneToOne(cascade=CascadeType.PERSIST)
    private Application application;
    @ManyToOne (cascade = CascadeType.PERSIST)
    private Company company;
    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    private List<Skill> skills = new ArrayList<>();

    public Job() {
    }

    public Job(String title, Double salary, Company company) {
        this.title = title;
        this.salary = salary;
        this.company = company;
        this.skills = skills;
    }


    public Long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
            this.application = application;
    }
//    @JsonManagedReference
    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Skill skill) {
        this.skills.add(skill);
        skill.setJob(this);
    }

//    @JsonBackReference
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString(){
        return getId()+" "+getTitle()+" "+ getSalary();
    }
}