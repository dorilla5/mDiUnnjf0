package com.fu.mDiUnnjf0.reboardingapi.businesslogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fu.mDiUnnjf0.reboardingapi.businesslogic.service.OfficeService;
import com.fu.mDiUnnjf0.reboardingapi.businesslogic.service.QueueService;
import com.fu.mDiUnnjf0.reboardingapi.dto.RegisterResponse;
import com.fu.mDiUnnjf0.reboardingapi.exception.UserStatusException;

@Component
public class RegisterManager {

    @Autowired
    QueueService queueService;
    @Autowired
    OfficeService officeService;

    @Autowired
    StatusManager statusManager;

    public RegisterResponse register(final String userName) {
        boolean alreadyOnTheList = false;
        try {
            final int status = queueService.status(userName);
            alreadyOnTheList = true;
        } catch (final UserStatusException exeption) {
            // nothing to do
        }
        if (alreadyOnTheList) {
            throw new UserStatusException("Sent user was already regitered");
        }
        if (officeService.staysIn(userName)) {
            throw new UserStatusException("Sent user is in the office currently");
        }
        queueService.register(userName);
        final int waitingListIndex = statusManager.status(userName);
        final RegisterResponse response = new RegisterResponse();
        response.setSucceed(waitingListIndex == 0);
        response.setWaitingListIndex(waitingListIndex);
        return response;
    }

}
