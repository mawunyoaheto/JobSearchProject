package edu.miu.cs.cs544.raymond.jobsearch.entity;

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

    public TechnicalInterview(LocalDate date, String phone_number, String email, double duration,  String questions,Location location) {
        super(date, phone_number, email);
        this.duration = duration;
        this.location = location;
        this.questions = questions;
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

    @Override
    public String toString() {
        return "TechnicalInterview{" +
                "duration=" + duration +
                ", location=" + location +
                ", questions='" + questions + '\'' +
                '}';
    }
}
