package com.ksquareinc.employeesservice.controllers;


import com.ksquareinc.employeesservice.models.Company;
import com.ksquareinc.employeesservice.models.Office;
import com.ksquareinc.employeesservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Company> findAll(){
        return companyService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Company company) {
        Company result = companyService.save(company);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Company company) {
        Company result = companyService.save(company);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody Company company){
        companyService.delete(company);
        return ResponseEntity.ok().body("Deleted company: \n" + company);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOne(@PathVariable("id") long id){
        Optional<Company> company = companyService.findOne(id);
        if (company.isPresent()){
            Company result = company.get();
            result = companyService.retrieveCompanyFiles(result);
            return  ResponseEntity.ok(result);
        }
        return ResponseEntity.status(503).body("Office not found");
    }
}
