package com.fu.mDiUnnjf0.queue.businessLogic;

import com.fu.mDiUnnjf0.queue.repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Business logic class for getting status. Now there is not much logic, but later, who knows...
 */
@Component
public class StatusManager {

    @Autowired
    private QueueRepository queueRepository;

    public Integer getStatus( final String username ) {
        return queueRepository.findByUserName(username).getIndexOfRegistration();
    }
}
