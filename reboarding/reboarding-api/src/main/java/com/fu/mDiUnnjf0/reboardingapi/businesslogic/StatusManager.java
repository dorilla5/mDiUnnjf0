package com.fu.mDiUnnjf0.reboardingapi.businesslogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fu.mDiUnnjf0.reboardingapi.businesslogic.service.OfficeService;
import com.fu.mDiUnnjf0.reboardingapi.businesslogic.service.QueueService;

@Component

public class StatusManager {

    @Autowired
    QueueService queueService;
    @Autowired
    OfficeService officeService;

    @Value("${officeCapacity}")
    private int officeCapacity;
    @Value("${maxRatio}")
    private double maxRatio;

    public int status(final String userName) {
        final int officeUserCount = officeService.count();
        return getWaitingListPositionFromStatus(queueService.status(userName), officeUserCount);
    }

    private int getWaitingListPositionFromStatus(final int status, final int officeUsercount) {
        final int freePlaces = (int) (maxRatio * officeCapacity - officeUsercount);
        return Math.max(0, status - freePlaces);
    }

}
