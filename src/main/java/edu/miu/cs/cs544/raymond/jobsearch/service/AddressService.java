package edu.miu.cs.cs544.raymond.jobsearch.service;

import edu.miu.cs.cs544.raymond.jobsearch.model.Address;

import java.util.List;

public interface AddressService {

    public Address getAddressById(long address_id);
    public List<Address> getAllAddress();
    public void addAddress(Address address);
}
