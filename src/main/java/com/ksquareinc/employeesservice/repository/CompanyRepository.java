package com.ksquareinc.employeesservice.repository;

import com.ksquareinc.employeesservice.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {


}
