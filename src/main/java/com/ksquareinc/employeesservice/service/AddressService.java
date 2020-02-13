package com.ksquareinc.employeesservice.service;

import com.ksquareinc.employeesservice.models.Address;
import com.ksquareinc.employeesservice.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;


    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> findAll() {
        List<Address> findAll = addressRepository.findAll();
        return findAll;
    }

    public void delete(Address address){
        addressRepository.delete(address);
    }

    public Optional<Address> findOne(long id){
        return addressRepository.findById(id);
    }



}

