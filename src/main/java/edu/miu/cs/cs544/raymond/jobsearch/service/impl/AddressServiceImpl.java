package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Address;
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

    @Override
    public Address getAddressById(long address_id) {
        return addressRepository.getById(address_id);
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address addAddress(Address address) {
       return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(long address_id, Address addressDetails) {
        addressRepository.save(addressDetails);
        return addressDetails;
    }

    @Override
    public void deleteAddress(long address_id) {
        addressRepository.deleteById(address_id);
    }
}
