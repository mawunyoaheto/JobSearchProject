package edu.miu.cs.cs544.raymond.jobsearch.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Interview_Type")
public abstract class Interview {
    @Id
    @GeneratedValue
    private Long id;
    @Version
    private int version;
    private LocalDate date;
    private String phone_number;
    private String email;
    @ManyToOne(cascade = CascadeType.ALL)
    private Job job;


    public Interview() {
    }

    public Interview(LocalDate date, String phone_number, String email) {
        this.date = date;
        this.phone_number = phone_number;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", date=" + date +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
