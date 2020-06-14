package com.fu.mDiUnnjf0.reboardingapi.businesslogic;

import org.springframework.beans.factory.annotation.Autowired;

import com.fu.mDiUnnjf0.reboardingapi.businesslogic.service.OfficeService;

public class ExitManager {

    @Autowired
    OfficeService officeService;

    public void exitUser(final String userName) {
        officeService.exit(userName);
    }

}
