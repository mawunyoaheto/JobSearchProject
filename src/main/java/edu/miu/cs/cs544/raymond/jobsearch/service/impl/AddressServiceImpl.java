package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.model.Address;
import edu.miu.cs.cs544.raymond.jobsearch.repository.AddressRepository;
import edu.miu.cs.cs544.raymond.jobsearch.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    public Address getAddressById(long address_id){
        return addressRepository.getById(address_id);
    }

    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    public void addAddress(Address address){
        addressRepository.save(address);
        long savedAddress = address.getId();

        //return addressRepository.getById(savedAddress);
    }
}
