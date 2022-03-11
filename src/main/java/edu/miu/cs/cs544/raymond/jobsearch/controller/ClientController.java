package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.model.Company;
import edu.miu.cs.cs544.raymond.jobsearch.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/clients/{client_id}")
    public Company getClientById(@PathVariable long client_id) {
        return clientService.getClientById(client_id);
    }

    @GetMapping("/clients")
    public List<Company> getAllClients() {
        return clientService.getAllClients();
    }

    @PutMapping("/clients/{client_id}")
    public void updateClient(@PathVariable long client_id, @RequestBody Company clientDetails) {
        Company client = clientService.getClientById(client_id);
//                .orElseThrow(()->new ResourceNotFoundEception("Skill not found for this id :: "+skill_id));
    }

    @PostMapping("/clients")
    public Company addClient(@RequestBody Company client) {
        clientService.addClient(client);
        long savedClientId = client.getId();
        return clientService.getClientById(savedClientId);
    }

    @DeleteMapping("clients/{client_id}")
    public void deleteClient(@PathVariable long client_id) {
        clientService.deleteClient(client_id);
    }
}
