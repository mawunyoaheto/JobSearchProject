package edu.miu.cs.cs544.raymond.jobsearch.service;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Client;

import java.util.List;

public interface ClientService {

    public Client getClientById(long client_id);
    public List<Client> getAllClients();
    public Client updateClient(long client_id, Client clientDetails);
    public Client addClient(Client client);
    public void deleteClient(long client_id);
}
