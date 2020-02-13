package com.ksquareinc.employeesservice.controllers;

import com.ksquareinc.employeesservice.models.Office;
import com.ksquareinc.employeesservice.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/office")
public class OfficeController {

    @Autowired
    OfficeService officeService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Office office) {
        Office result = officeService.save(office);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        List<Office> findAll = officeService.findAll();
        return ResponseEntity.ok(findAll);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOne(@PathVariable("id")long id){
        Optional<Office> office = officeService.findOne(id);

        return ResponseEntity.status(503).body("Office not found");
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody Office office){
        officeService.delete(office);
        return ResponseEntity.ok("Deleted " + office);
    }
}