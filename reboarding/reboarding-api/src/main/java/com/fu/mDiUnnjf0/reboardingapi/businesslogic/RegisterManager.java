package com.fu.mDiUnnjf0.reboardingapi.businesslogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${officeCapacity}")
    private int officeCapacity;
    @Value("${maxRatio}")
    private double maxRatio;

    public RegisterResponse register(final String userName) {
        final int officeUserCount = officeService.count();
        boolean alreadyOnTheList = false;
        try {
            final int status = queueService.status(userName);
            alreadyOnTheList = true;
        } catch (final UserStatusException exeption) {
            // nothing to do
        }
        if (alreadyOnTheList || officeService.staysIn(userName)) {
            throw new UserStatusException();
        }
        queueService.register(userName);
        return buildRegisterResponseFromStatus(queueService.status(userName), officeUserCount);
    }

    private RegisterResponse buildRegisterResponseFromStatus(final int status, final int officeUsercount) {
        final RegisterResponse response = new RegisterResponse();
        final int freePlaces = (int) (maxRatio * officeCapacity - officeUsercount);
        response.setSucceed(status <= freePlaces);
        response.setWaitingListIndex(Math.max(0, status - freePlaces));
        return response;
    }

}
