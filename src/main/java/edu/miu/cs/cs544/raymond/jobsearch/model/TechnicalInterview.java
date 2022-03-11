package edu.miu.cs.cs544.raymond.jobsearch.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Technical")
public class TechnicalInterview extends Interview{
    private double duration;
    @Enumerated
    private Location location;
    private String questions;

    public TechnicalInterview() {
    }

    public TechnicalInterview(double duration, Location location, String questions, LocalDate date,String phone, String email) {
        this.duration = duration;
        this.location = location;
        this.questions = questions;
        super.setDate(date);
        super.setPhone_number(phone);
        super.setEmail(email);
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }
}
