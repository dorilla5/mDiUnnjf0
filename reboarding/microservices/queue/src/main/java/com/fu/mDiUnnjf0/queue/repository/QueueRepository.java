package com.fu.mDiUnnjf0.queue.repository;

import java.util.Optional;

import com.fu.mDiUnnjf0.queue.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QueueRepository extends JpaRepository<Queue, Long> {

    Optional<Queue> findByUserName( final String userName);

    @Query( value = "SELECT max(indexOfRegistration) FROM Queue")
    Optional<Integer> getMaxIndexOfRegistration();
}
