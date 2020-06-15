package com.fu.mDiUnnjf0.reboardingapi.businesslogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fu.mDiUnnjf0.reboardingapi.businesslogic.service.QueueService;

@Component

public class StatusManager {

    @Autowired
    QueueService queueService;

    public StatusManager() {
        // TODO Auto-generated constructor stub
    }

    public int status(final String userName) {
        return queueService.status(userName);
    }

}
