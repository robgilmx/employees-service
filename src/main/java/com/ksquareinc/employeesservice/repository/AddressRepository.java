package com.ksquareinc.employeesservice.repository;

import com.ksquareinc.employeesservice.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {


}
