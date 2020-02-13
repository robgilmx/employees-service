package com.ksquareinc.employeesservice.service;

import com.ksquareinc.employeesservice.config.WebClientConfig;
import com.ksquareinc.employeesservice.models.Office;
import com.ksquareinc.employeesservice.repository.OfficeRepository;
import com.sun.media.jfxmedia.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;

@Service
public class OfficeService {

    @Autowired
    OfficeRepository officeRepository;

    @Value("${microservices.files}")
    String fileMicroservice;

    @Value("${spring.security.oauth2.client.registration.files-service.client-name}")
    String filesClient;


    @Autowired
    WebClient webClient;

    @Autowired
    WebClient otherWebClient;

    @Autowired
    WebClient.Builder webClientBuilder;

    public Office save(Office office) {
        return officeRepository.save(office);
    }

    public List<Office> findAll() {
        List<Office> findAll = officeRepository.findAll();
        return findAll;
    }

    public void delete(Office office){
        officeRepository.delete(office);
    }

    public Optional<Office> findOne(long id){
        Optional<Office> office = officeRepository.findById(id);
        return office;
    }

    public Office retrieveOfficeFiles(Office e) {
        try{
            e.setFiles(
                    WebClientConfig.callClient(webClient, fileMicroservice + "/api/file?office=" + e.getId(), filesClient).getContent()
            );
        }catch (NullPointerException npe){
            Logger.logMsg(Logger.ERROR, "Error in files for office id: "+ e.getId());
        }
        return e;
    }


}

