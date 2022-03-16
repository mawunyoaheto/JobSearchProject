package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Company;
import edu.miu.cs.cs544.raymond.jobsearch.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping(path = "/clients/{client_id}")
    public ResponseEntity<Company> getClientById(@PathVariable long client_id) {
        Company foundClient = clientService.getClientById(client_id);
        return ResponseEntity.ok(foundClient);
    }

    @GetMapping(path = "/clients")
    public ResponseEntity<List<Company>> getAllClients() {
        List<Company> listOfFoundClients = clientService.getAllClients();
        return ResponseEntity.ok(listOfFoundClients);
    }

    @PostMapping(path = "/clients")
    public ResponseEntity<Company> addClient(@RequestBody Company client) {
        Company createdClient = clientService.addClient(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdClient.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .body(createdClient);
    }

    @PutMapping(path = "/clients/{client_id}")
    public ResponseEntity<Company> updateClient(@PathVariable long client_id, @RequestBody Company clientDetails) {
        Company updatedClient  = clientService.updateClient(client_id, clientDetails);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping(path = "clients/{client_id}")
    public ResponseEntity<Void> deleteClient(@PathVariable long client_id) {
        clientService.deleteClient(client_id);
        return ResponseEntity.noContent().build();
    }
}
