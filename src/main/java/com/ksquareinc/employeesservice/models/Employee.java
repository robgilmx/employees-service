package com.ksquareinc.employeesservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;
    @Column
    private String phone;
    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "tax_registry")
    private String taxRegistry;
    @Column(name = "company_id")
    private String companyId;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "join_date")
    private LocalDate joinDate;
    @ManyToOne
    @JsonIgnoreProperties("employees")
    private Office office;
    @OneToOne
    @JoinColumn(unique = true)
    private Address address;
    @OneToOne
    @JoinColumn(unique = true)
    private Position position;
    @ManyToOne
    @JsonIgnoreProperties("employees")
    private Employee manager;
    @Transient
    private List<TimeOff> timeOffs = new ArrayList<>();
    @Transient
    private List<File> files = new ArrayList<>();
    @Transient
    private VacationRights vacationRights;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<TimeOff> getTimeOffs() {
        return timeOffs;
    }

    public void setTimeOffs(List<TimeOff> timeOffs) {
        this.timeOffs = timeOffs;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public VacationRights getVacationRights() {
        return vacationRights;
    }

    public void setVacationRights(VacationRights vacationRights) {
        this.vacationRights = vacationRights;
    }
}
