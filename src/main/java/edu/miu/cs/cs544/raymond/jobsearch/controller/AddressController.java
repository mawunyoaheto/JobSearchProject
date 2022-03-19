package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Address;
import edu.miu.cs.cs544.raymond.jobsearch.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address/{address_id}")
    public ResponseEntity<Address> getAddressById(@PathVariable long address_id){
        Address foundAddress = addressService.getAddressById(address_id);
        return ResponseEntity.ok(foundAddress);
    }

    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAllAddress(){
        List<Address> foundAddresses = addressService.getAllAddress();
        return ResponseEntity.ok(foundAddresses);
    }

    @PostMapping("/companies/{company_id}/address")
    public ResponseEntity<Address> addAddress(@PathVariable long company_id, @RequestBody Address address){
        Address createdAddress = addressService.addAddress(company_id,address);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdAddress.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .body(createdAddress);
    }

    @PutMapping(path = "/companies/{company_id}/address/{address_id}")
    public ResponseEntity<Address> updateAddress(@PathVariable long company_id,@PathVariable long address_id, @RequestBody Address address){
       Address updatedAddress = addressService.updateAddress(company_id,address_id,address);
       return ResponseEntity.ok(updatedAddress);
    }

    @DeleteMapping(path = "/address/{address_id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable long address_id){
        addressService.deleteAddress(address_id);
        return ResponseEntity.noContent().build();
    }
}
