package edu.miu.cs.cs544.raymond.jobsearch.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("RECRUITER")
public class Recruiter extends Company{
    @OneToMany
    private List<Client> clients = new ArrayList<>();
    public Recruiter(){
        super();
    }

    public Recruiter(String name, Address address) {
        super(name, address);
        this.clients = clients;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
