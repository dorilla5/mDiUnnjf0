package com.fu.mDiUnnjf0.reboardingapi.businesslogic.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OfficeService extends Service {

    private final RestTemplate office = new RestTemplate();

    @Value("${entryURL}")
    private String entryURL;

    @Value("${exitURL}")
    private String exitURL;

    @Value("${staysInURL}")
    private String staysInURL;

    public void entry(final String userName) {
        postRequestAndCheckStatus(office, entryURL + userName, HttpMethod.POST);
    }

    public void exit(final String userName) {
        postRequestAndCheckStatus(office, entryURL + userName, HttpMethod.POST);

    }

    public Boolean staysIn(final String userName) {
        return office.getForObject(staysInURL + userName, Boolean.class);
    }

    public Integer count() {
        return office.getForObject(staysInURL, Integer.class);
    }
}
