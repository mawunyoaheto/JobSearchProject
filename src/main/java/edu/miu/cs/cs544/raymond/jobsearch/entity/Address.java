package edu.miu.cs.cs544.raymond.jobsearch.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private int version;
    private String Street;
    private String city;
    private String state;
    private int zipcode;
    @OneToOne(mappedBy ="address")
    private Company company;


    public Address() {
    }

    public Address(String street, String city, String state, int zipcode) {
        Street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

//    @JsonBackReference
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", Street='" + Street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode=" + zipcode +
                ", company=" + company +
                '}';
    }
}
