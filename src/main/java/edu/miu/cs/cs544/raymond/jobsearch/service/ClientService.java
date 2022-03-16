package edu.miu.cs.cs544.raymond.jobsearch.service;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Company;

import java.util.List;

public interface ClientService {

    public Company getClientById(long client_id);
    public List<Company> getAllClients();
    public Company updateClient(long client_id, Company clientDetails);
    public Company addClient(Company client);
    public void deleteClient(long client_id);
}
