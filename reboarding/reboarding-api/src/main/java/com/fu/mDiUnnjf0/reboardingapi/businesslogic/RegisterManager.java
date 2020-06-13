package com.fu.mDiUnnjf0.reboardingapi.businesslogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fu.mDiUnnjf0.reboardingapi.businesslogic.service.OfficeService;
import com.fu.mDiUnnjf0.reboardingapi.businesslogic.service.QueueService;
import com.fu.mDiUnnjf0.reboardingapi.dto.RegisterResponse;

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
        // TODO
        // check is in the office
        // check is in the queue
        // if not
        // register request
        final RegisterResponse response = new RegisterResponse();
        response.setWaitingListIndex(0);
        return response;
    }

}
