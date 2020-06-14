package com.fu.mDiUnnjf0.reboardingapi.businesslogic.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fu.mDiUnnjf0.reboardingapi.exception.UserStatusException;

@Component
public class OfficeService {

    private final RestTemplate office = new RestTemplate();

    @Value("${entryURL}")
    private String entryURL;

    @Value("${exitURL}")
    private String exitURL;

    @Value("${staysInURL}")
    private String staysInURL;

    public void entry(final String userName) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<Object> entity = new HttpEntity<Object>(headers);

        final ResponseEntity<String> out = office.exchange(entryURL + userName, HttpMethod.POST, entity, String.class);
        if (!out.getStatusCode().equals(HttpStatus.OK)) {
            throw new UserStatusException();
        }
    }

    public void exit(final String userName) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<Object> entity = new HttpEntity<Object>(headers);

        final ResponseEntity<String> out = office.exchange(exitURL + userName, HttpMethod.POST, entity, String.class);
        if (!out.getStatusCode().equals(HttpStatus.OK)) {
            throw new UserStatusException();
        }
    }

    public Boolean staysIn(final String userName) {
        return office.getForObject(staysInURL + userName, Boolean.class);
    }

    public Integer count() {
        return office.getForObject(staysInURL, Integer.class);
    }
}
