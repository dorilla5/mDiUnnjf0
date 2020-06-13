package com.fu.mDiUnnjf0.queue.businessLogic;

import java.util.Optional;

import com.fu.mDiUnnjf0.queue.entity.Queue;
import com.fu.mDiUnnjf0.queue.repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Business logic class for handling queue operations. Now there is not much logic, but later, who knows...
 */
@Component
public class QueueManager {

    @Autowired
    private QueueRepository queueRepository;

    public Integer getStatus( final String username ) {
        return queueRepository.findByUserName(username).getIndexOfRegistration();
    }

    public void delete( final String userName ) {
        queueRepository.deleteQueueByUserName(userName);
    }

    public void add( final String userName ) {
        Queue newItem = new Queue();
        newItem.setUserName(userName);
        final Optional<Integer> maxIndexOfRegistration = queueRepository.getMaxIndexOfRegistration();
        newItem.setIndexOfRegistration(maxIndexOfRegistration.map(max -> max + 1).orElse(1));
        queueRepository.save(newItem);
    }
}
