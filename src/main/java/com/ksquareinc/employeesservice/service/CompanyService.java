package com.ksquareinc.employeesservice.service;

import com.ksquareinc.employeesservice.config.WebClientConfig;
import com.ksquareinc.employeesservice.models.Company;
import com.ksquareinc.employeesservice.repository.CompanyRepository;
import com.sun.media.jfxmedia.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Value("${microservices.files}")
    String fileMicroservice;

    @Value("${spring.security.oauth2.client.registration.files-service.client-name}")
    String filesClient;

    @Autowired
    WebClient webClient;

    private final Consumer<Map<String, Object>> clientRegistrationId = clientRegistrationId("employees-service");

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> findAll() {
        List<Company> findAll = companyRepository.findAll();
        return findAll;
    }

    public void delete(Company company){
        companyRepository.delete(company);
    }

    public Optional<Company> findOne(long id){
        return companyRepository.findById(id);
    }

    public Company retrieveCompanyFiles(Company e) {
        try{
            e.setFiles(
                    WebClientConfig.callClient(webClient, fileMicroservice + "/api/file?company=" + e.getId(), filesClient).getContent()
            );
        }catch (NullPointerException npe){
            Logger.logMsg(Logger.ERROR, "Error in files for company id: "+ e.getId());
        }
        return e;
    }


}

