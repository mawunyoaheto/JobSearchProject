package edu.miu.cs.cs544.raymond.jobsearch.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Screening")
public class ScreeningInterview extends Interview{
    private String name;
    private String result;

    public ScreeningInterview() {
    }

    public ScreeningInterview(String name, String result, LocalDate date, String phone, String email) {
       super.setEmail(email);
       super.setPhone_number(phone);
       super.setDate(date);
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ScreeningInterview{" +
                "name='" + name + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
