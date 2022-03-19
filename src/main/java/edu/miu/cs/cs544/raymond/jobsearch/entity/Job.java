package edu.miu.cs.cs544.raymond.jobsearch.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "job")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Job implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private int version;
    private String title;
    private float salary;
    @OneToOne(cascade=CascadeType.ALL)
    private Application application;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Company company;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Skill> skills;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Interview> interviews;

    public Job() {
    }

    public Job(String title, float salary) {
        this.title = title;
        this.salary = salary;
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

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
            this.application = application;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills=skills;
    }

    public void  addSkill(Skill skill){
        this.skills.add(skill);
    }

//    public Company getCompany() {
//        return company;
//    }


    public List<Interview> getInterviews() {
        return interviews;
    }

    public void setInterviews(List<Interview> interviews) {
        this.interviews = interviews;
    }

    public void addInterview(Interview interview){
        this.interviews.add(interview);
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString(){
        return getId()+" "+getTitle()+" "+ getSalary();
    }
}