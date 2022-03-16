package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Company;
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
    public Company getClientById(long client_id) {
        return clientRepository.getById(client_id);
    }

    @Override
    public List<Company> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Company updateClient(long client_id, Company clientDetails) {
        clientRepository.save(clientDetails);
        return clientDetails;
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
