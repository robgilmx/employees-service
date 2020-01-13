package com.ksquareinc.employeesservice.controllers;

import com.ksquareinc.employeesservice.models.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> findAllEmployees(){
        return Collections.singletonList(new Employee(1, "roberto.gil@ksquareinc.com", "9999979832","Roberto Esteban","Gil Flores", LocalDate.of(1995,10,27),LocalDate.of(2019,3,14)));
    }
}
