package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Client;
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
    public ResponseEntity<Client> getClientById(@PathVariable long client_id) {
        return ResponseEntity.ok(clientService.getClientById(client_id));
    }

    @GetMapping(path = "/clients")
    public ResponseEntity<List<Client>> getAllClients() {
            return ResponseEntity.ok(clientService.getAllClients());
    }

    @PostMapping(path = "/clients")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client createdClient = clientService.addClient(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdClient.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .body(createdClient);
    }

    @PutMapping(path = "/clients/{client_id}")
    public ResponseEntity<Client> updateClient(@PathVariable long client_id, @RequestBody Client clientDetails) {
        Client updatedClient  = clientService.updateClient(client_id, clientDetails);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping(path = "clients/{client_id}")
    public ResponseEntity<Void> deleteClient(@PathVariable long client_id) {
        clientService.deleteClient(client_id);
        return ResponseEntity.noContent().build();
    }
}
