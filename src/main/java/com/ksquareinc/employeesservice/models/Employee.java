package com.ksquareinc.employeesservice.models;

import java.time.LocalDate;
import java.util.List;

public class Employee {
    private long id;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String taxRegistry;
    private String companyId;
    private LocalDate birthday;
    private LocalDate joinDate;
    private Office office;
    private Position position;
    private Employee manager;

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getTaxRegistry() {
        return taxRegistry;
    }

    public void setTaxRegistry(String taxRegistry) {
        this.taxRegistry = taxRegistry;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
