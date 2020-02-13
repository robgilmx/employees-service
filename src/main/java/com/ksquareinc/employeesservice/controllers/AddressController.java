package com.ksquareinc.employeesservice.controllers;

import com.ksquareinc.employeesservice.models.Address;
import com.ksquareinc.employeesservice.models.Position;
import com.ksquareinc.employeesservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Address> findAll(){
        return addressService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Address address) {
        Address result = addressService.save(address);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Address address) {
        Address result = addressService.save(address);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody Address address){
        addressService.delete(address);
        return ResponseEntity.ok().body("Deleted address: \n" + address);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOne(@PathVariable("id") long id){
        Optional<Address> address = addressService.findOne(id);
        if (address.isPresent()){
            Address result = address.get();
            return  ResponseEntity.ok(result);
        }
        return ResponseEntity.status(503).body("Office not found");
    }
}
