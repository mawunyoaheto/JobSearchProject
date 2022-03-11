package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.model.Company;
import edu.miu.cs.cs544.raymond.jobsearch.repository.ClientRepository;
import edu.miu.cs.cs544.raymond.jobsearch.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public Company getClientById(long client_id) {
        return clientRepository.getById(client_id);
    }

    @Override
    public List<Company> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public void updateClient(long client_id, Company clientDetails) {
        Company client = clientRepository.getById(client_id);
//                .orElseThrow(()->new ResourceNotFoundEception("Skill not found for this id :: "+skill_id));
    }

    @Override
    public Company addClient(Company client) {
        clientRepository.save(client);
        long savedClientId = client.getId();
        return clientRepository.getById(savedClientId);
    }

    @Override
    public void deleteClient(long client_id) {
        clientRepository.deleteById(client_id);
    }
}
