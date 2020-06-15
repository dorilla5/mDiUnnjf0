package com.fu.mDiUnnjf0.reboardingapi.businesslogic.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class QueueService extends Service {

    private final RestTemplate queue = new RestTemplate();

    @Value("${statusURL}")
    private String statusURL;

    @Value("${registerURL}")
    private String registerURL;

    public Integer status(final String userName) {
        final String body = postRequestAndCheckStatus(queue, statusURL + userName);
        return Integer.parseInt(body);
    }

    public void register(final String userName) {
        postRequestAndCheckStatus(queue, registerURL + userName);
    }
}
