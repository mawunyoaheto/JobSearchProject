package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.model.Company;
import edu.miu.cs.cs544.raymond.jobsearch.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/clients/{client_id}")
    public Company getClientById(@PathVariable long client_id){
        return clientRepository.getById(client_id);
    }

    @GetMapping("/clients")
    public List<Company> getAllClients(){
        return clientRepository.findAll();
    }


    @PutMapping("/clients/{client_id}")
    public void updateClient(@PathVariable long client_id, @RequestBody Company clientDetails){
       Company client = clientRepository.getById(client_id);


//                .orElseThrow(()->new ResourceNotFoundEception("Skill not found for this id :: "+skill_id));

    }

    @PostMapping("/clients")
    public Company addClient(@RequestBody Company client){
        clientRepository.save(client);
        long savedClientId = client.getId();
        return clientRepository.getById(savedClientId);
    }

    @DeleteMapping("clients/{client_id}")
    public void deleteClient(@PathVariable long client_id){
        clientRepository.deleteById(client_id);
    }
}
