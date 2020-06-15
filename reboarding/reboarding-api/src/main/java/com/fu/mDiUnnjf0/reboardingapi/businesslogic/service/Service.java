package com.fu.mDiUnnjf0.reboardingapi.businesslogic.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fu.mDiUnnjf0.reboardingapi.exception.UserStatusException;

public abstract class Service {

    protected String postRequestAndCheckStatus(final RestTemplate restTemplate, final String url) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<Object> entity = new HttpEntity<Object>(headers);

        final ResponseEntity<String> out = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        if (!out.getStatusCode().equals(HttpStatus.OK)) {
            throw new UserStatusException();
        }
        return out.getBody();
    }

}
