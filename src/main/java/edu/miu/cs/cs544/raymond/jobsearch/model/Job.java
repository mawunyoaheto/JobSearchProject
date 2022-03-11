package edu.miu.cs.cs544.raymond.jobsearch.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "job")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "getAllJobsWithApplication",
                query = "select * from job j inner join application a  ON j.APPLICATION_ID=a.ID",
                resultClass=Job.class
        )
})
@NamedQuery(name="Job.findJobByState", query="SELECT j FROM Job j WHERE j.company.address.state = 'IA'")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Job {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private Double salary;
    @OneToOne(cascade=CascadeType.PERSIST)
    private Application application;
    @ManyToOne (cascade = CascadeType.PERSIST)
    private Company company;
    @OneToMany(mappedBy = "job", cascade = CascadeType.PERSIST)
    private List<Skill> skills = new ArrayList<>();

    public Job() {
    }

    public Job(String title, Double salary, Company company) {
        this.title = title;
        this.salary = salary;
        this.company = company;
        this.skills = skills;
    }


    public long getId() {
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