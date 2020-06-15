package com.fu.mDiUnnjf0.reboardingapi.businesslogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fu.mDiUnnjf0.reboardingapi.businesslogic.service.OfficeService;

@Component
public class ExitManager {

    @Autowired
    OfficeService officeService;

    public void exitUser(final String userName) {
        officeService.exit(userName);
    }

}
