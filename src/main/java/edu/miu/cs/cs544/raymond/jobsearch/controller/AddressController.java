package edu.miu.cs.cs544.raymond.jobsearch.controller;

import edu.miu.cs.cs544.raymond.jobsearch.model.Address;
import edu.miu.cs.cs544.raymond.jobsearch.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/address/{address_id}")
    public Address getAddressById(@PathVariable long address_id){
        return addressService.getAddressById(address_id);
    }

    @GetMapping("/address")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }

    @PostMapping("/address")
    public void addAddress(@RequestBody Address address){
        addressService.addAddress(address);
    }

    @PutMapping(path = "/address/{address_id}")
    public void updateAddress(@PathVariable long address_id, @RequestBody Address address){
        addressService.updateAddress(address_id,address);
    }

    @DeleteMapping(path = "/address/{address_id}")
    public void deleteAddress(@PathVariable long address_id){
        addressService.deleteAddress(address_id);
    }
}
