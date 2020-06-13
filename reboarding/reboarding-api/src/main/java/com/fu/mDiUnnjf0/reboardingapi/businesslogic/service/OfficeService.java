package com.fu.mDiUnnjf0.reboardingapi.businesslogic.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
        office.postForLocation(entryURL + userName, "");
    }

    public void exit(final String userName) {
        office.postForLocation(exitURL + userName, "");
    }

    public Boolean staysIn(final String userName) {
        return office.getForObject(staysInURL + userName, Boolean.class);
    }

    public Integer count() {
        return office.getForObject(staysInURL, Integer.class);
    }
}
