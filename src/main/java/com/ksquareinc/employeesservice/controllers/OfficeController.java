package com.ksquareinc.employeesservice.controllers;

import com.ksquareinc.employeesservice.models.Office;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@RequestMapping("/office")
public class OfficeController {

    public List<Office> findAll(){
        return Collections.singletonList()
    }

}
