package com.ksquareinc.employeesservice.controllers;

import com.ksquareinc.employeesservice.models.Employee;
import com.ksquareinc.employeesservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Employee employee) {
        Employee result = employeeService.save(employee);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Employee employee) {
        Employee result = employeeService.save(employee);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        List<Employee> findAll = employeeService.findAll();
        return ResponseEntity.ok(findAll);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOne(@PathVariable("id")long id){
        Optional<Employee> employee = employeeService.findOne(id);
        if (employee.isPresent()){
            Employee result = employee.get();
            result = employeeService.retrieveEmployeeFiles(result);
            return  ResponseEntity.ok(result);
        }
        return ResponseEntity.status(503).body("Employee not found");
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody Employee employee){
        employeeService.delete(employee);
        return ResponseEntity.ok("Deleted " + employee);
    }
}