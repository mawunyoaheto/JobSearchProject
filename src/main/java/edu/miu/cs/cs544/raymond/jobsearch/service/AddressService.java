package edu.miu.cs.cs544.raymond.jobsearch.service;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Address;

import java.util.List;

public interface AddressService {

    public Address getAddressById(long address_id);
    public List<Address> getAllAddress();
    public Address addAddress(Address address);
    public Address updateAddress(long address_id, Address addressDetails);
    public void deleteAddress(long address_id);
}
