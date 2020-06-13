package com.fu.mDiUnnjf0.queue.repository;

import com.fu.mDiUnnjf0.queue.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueRepository extends JpaRepository<Queue, Long> {

    Queue findByUserName( final String userName);
}
