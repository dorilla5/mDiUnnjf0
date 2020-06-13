package com.fu.mDiUnnjf0.reboardingapi.businesslogic.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class QueueService {

    private final RestTemplate queue = new RestTemplate();

    @Value("${statusURL}")
    private String statusURL;

    @Value("${registerURL}")
    private String registerURL;

    public Integer status(final String userName) {
        return queue.getForObject(statusURL, Integer.class);
    }

    public void register(final String userName) {
        queue.postForLocation(registerURL, "");
    }
}
