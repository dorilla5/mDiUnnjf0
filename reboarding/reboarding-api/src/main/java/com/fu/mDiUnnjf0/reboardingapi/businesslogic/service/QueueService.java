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
public class QueueService {

    private final RestTemplate queue = new RestTemplate();

    @Value("${statusURL}")
    private String statusURL;

    @Value("${registerURL}")
    private String registerURL;

    public Integer status(final String userName) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<Object> entity = new HttpEntity<Object>(headers);

        final ResponseEntity<String> out = queue.exchange(statusURL + userName, HttpMethod.POST, entity, String.class);
        if (!out.getStatusCode().equals(HttpStatus.OK)) {
            throw new UserStatusException();
        }
        return Integer.parseInt(out.getBody());
    }

    public void register(final String userName) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<Object> entity = new HttpEntity<Object>(headers);
        final ResponseEntity<String> out = queue.exchange(registerURL + userName, HttpMethod.POST, entity,
                String.class);
        if (!out.getStatusCode().equals(HttpStatus.OK)) {
            throw new UserStatusException();
        }
    }
}
