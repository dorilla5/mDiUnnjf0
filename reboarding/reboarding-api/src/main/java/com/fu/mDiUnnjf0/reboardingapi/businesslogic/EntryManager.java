package com.fu.mDiUnnjf0.reboardingapi.businesslogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fu.mDiUnnjf0.reboardingapi.businesslogic.service.OfficeService;
import com.fu.mDiUnnjf0.reboardingapi.businesslogic.service.QueueService;
import com.fu.mDiUnnjf0.reboardingapi.exception.UserStatusException;

@Component
public class EntryManager {

    @Autowired
    QueueService queueService;
    @Autowired
    OfficeService officeService;

    @Value("${officeCapacity}")
    private int officeCapacity;
    @Value("${maxRatio}")
    private double maxRatio;

    public boolean entryUser(final String userName) {
        final int status = queueService.status(userName);
        final int count = officeService.count();
        if (status + count <= (int) (maxRatio * officeCapacity)) {
            if (!officeService.staysIn(userName)) {
                officeService.entry(userName);
                return true;
            } else {
                throw new UserStatusException();
            }
        }
        return false;
    }

}
