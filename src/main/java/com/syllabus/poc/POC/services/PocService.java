package com.syllabus.poc.POC.services;

import com.syllabus.poc.POC.entities.DataRec;
import com.syllabus.poc.POC.entities.Register;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.http.HttpHeaders;


@Service
@Slf4j
public class PocService {


    @Value("${poc.base-url}")
    private String pocBaseUrl;


    public DataRec getData(String seedId){
        RestTemplate restTemplate  = new RestTemplate();
        //HttpHeaders headers = new HttpHeaders();
        DataRec dataRec = new DataRec();
        URI uri = getUri(seedId);
        try {
            Register register = restTemplate.getForObject(uri, Register.class);
            if (register == null) {
                log.info("----------------Seed API return null for this seed {}", seedId);
                return null;
            }
            dataRec = register.getDataRec();
        } catch (RestClientException e) {
            log.error("Rest client exception : {}, {}", e.getMessage(), e.getStackTrace());
        }
        log.info(dataRec.toString());
        return dataRec;
    }

    private URI getUri(String seedId){
        log.info("Input value : {}", seedId);
        String url = pocBaseUrl;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("registrierungsnummer", seedId);

        log.info("Seed Api called {}", builder.toUriString());
        return builder.build().encode().toUri();
    }
}
