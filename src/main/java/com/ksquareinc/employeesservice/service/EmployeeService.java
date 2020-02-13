package com.ksquareinc.employeesservice.service;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;

import com.ksquareinc.employeesservice.config.WebClientConfig;
import com.ksquareinc.employeesservice.models.Employee;
import com.ksquareinc.employeesservice.repository.EmployeeRepository;
import com.sun.media.jfxmedia.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Value("${microservices.files}")
    String fileMicroservice;

    @Value("${spring.security.oauth2.client.registration.files-service.client-name}")
    String fileClient;

    @Value("${microservices.time}")
    String timeMicroservices;

    @Value("${spring.security.oauth2.client.registration.time-management-service.client-name}")
    String timeManagerClient;

    @Autowired
    WebClient webClient;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        List<Employee> findAll = employeeRepository.findAll();
        return findAll;
    }

    public void delete(Employee employee){
        employeeRepository.delete(employee);
    }

    public Optional<Employee> findOne(long id){
        return employeeRepository.findById(id);
    }

    public Employee retrieveEmployeeFiles(Employee e) {
        try{
            e.setFiles(
                    WebClientConfig.callClient(webClient, fileMicroservice + "api/file?employee=" + e.getId(), fileClient).getContent()
            );
        }
        catch (WebClientResponseException | NullPointerException wcre){
            Logger.logMsg(Logger.ERROR, "Error in files for employee id: "+ e.getId());
        }

        try{
            e.setTimeOffs(
                    WebClientConfig.callClient(webClient,timeMicroservices + "api/timeoff?employee=" + e.getId(), timeManagerClient ).getContent()
            );
        }
        catch (WebClientResponseException | NullPointerException wcre){
            Logger.logMsg(Logger.ERROR, "Error in files for employee id: "+ e.getId());
        }


        return e;
    }


}

