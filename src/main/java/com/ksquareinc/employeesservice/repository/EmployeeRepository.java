package com.ksquareinc.employeesservice.repository;

import com.ksquareinc.employeesservice.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
