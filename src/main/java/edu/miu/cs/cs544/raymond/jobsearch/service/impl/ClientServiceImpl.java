package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Client;
import edu.miu.cs.cs544.raymond.jobsearch.exception.ResourceNotFoundException;
import edu.miu.cs.cs544.raymond.jobsearch.repository.ClientRepository;
import edu.miu.cs.cs544.raymond.jobsearch.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public Client getClientById(long client_id) {
      return clientRepository.findById(client_id).orElseThrow(()-> new ResourceNotFoundException("client with given id not found"));
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client updateClient(long client_id, Client clientDetails) {
       Client foundClient =  clientRepository.findById(client_id).orElseThrow(()-> new ResourceNotFoundException("client with given id not found"));
       foundClient.setName(clientDetails.getName());
       foundClient.setAddress(clientDetails.getAddress());
       foundClient.setJobs(clientDetails.getJobs());
        return clientRepository.save(foundClient);
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(long client_id) {
        clientRepository.deleteById(client_id);
    }
}
