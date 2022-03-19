package edu.miu.cs.cs544.raymond.jobsearch.service.impl;

import edu.miu.cs.cs544.raymond.jobsearch.entity.Address;
import edu.miu.cs.cs544.raymond.jobsearch.entity.Company;
import edu.miu.cs.cs544.raymond.jobsearch.repository.AddressRepository;
import edu.miu.cs.cs544.raymond.jobsearch.service.AddressService;
import edu.miu.cs.cs544.raymond.jobsearch.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CompanyService companyService;

    @Override
    public Address getAddressById(long address_id) {
        return addressRepository.getById(address_id);
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address addAddress(long company_id, Address address) {
        Company foundCompany = companyService.getCompany(company_id).orElseThrow();
        address.setCompany(foundCompany);
       return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(long company_id, long address_id, Address addressDetails) {
        Company foundCompany = companyService.getCompany(company_id).orElseThrow();
        Address foundAddress = addressRepository.findById(address_id).orElseThrow();
        foundAddress=addressDetails;
        foundAddress.setCompany(foundCompany);
        return addressRepository.save(addressDetails);
    }

    @Override
    public void deleteAddress(long address_id) {
        addressRepository.deleteById(address_id);
    }
}
