package edu.miu.cs.cs544.raymond.jobsearch.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("HiringManager")
public class HiringManagerInterview extends Interview{
    private int team_size;
    private LocalDate start_date;


    public HiringManagerInterview() {
    }

    public HiringManagerInterview(String phone_num, String email,int team_size, LocalDate start_date) {
        super.setDate(start_date);
        super.setPhone_number(phone_num);
        super.setEmail(email);
        this.team_size = team_size;
        this.start_date = start_date;
    }

    public int getTeam_size() {
        return team_size;
    }

    public void setTeam_size(int team_size) {
        this.team_size = team_size;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    @Override
    public String toString() {
        return "HiringManagerInterview{" +
                "team_size=" + team_size +
                ", start_date=" + start_date +
                '}';
    }
}
