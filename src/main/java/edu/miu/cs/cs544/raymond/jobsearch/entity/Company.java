package edu.miu.cs.cs544.raymond.jobsearch.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Company implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Version
    private int version;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToMany(mappedBy="company",cascade = CascadeType.ALL)
    private List<Job> jobs =new ArrayList<>();

    public Company() {
    }

    public Company(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @JsonManagedReference
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    @JsonManagedReference
    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", jobs=" + jobs +
                '}';
    }
}
