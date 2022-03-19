package edu.miu.cs.cs544.raymond.jobsearch.entity;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@DiscriminatorValue("CLIENT")
public class Client extends Company {
    private  String mission;
    private String reason;
    private String website;
    @ManyToOne(cascade = CascadeType.ALL)
    private Recruiter recruiter;

    public  Client(){
        super();
    }

    public Client(String name, Address address, List<Job> jobs,String mission, String reason, String website) {
        super(name, address,jobs);
        this.mission = mission;
        this.reason = reason;
        this.website = website;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getName(){
        return super.getName();
    }

    public Address getAddress(){
        return super.getAddress();
    }

    @Override
    public String toString() {
        return "Client{" +
                "mission='" + mission + '\'' +
                ", reason='" + reason + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
