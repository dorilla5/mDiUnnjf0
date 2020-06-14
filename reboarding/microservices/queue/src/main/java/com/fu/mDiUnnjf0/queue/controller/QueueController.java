package com.fu.mDiUnnjf0.queue.controller;

import com.fu.mDiUnnjf0.queue.businessLogic.QueueManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class QueueController {

    @Autowired
    private QueueManager queueManager;

    /**
     * this method is for getting the index of the registration of the user.
     * @param userName
     *          the id of the user.
     * @return the index of the registration of the user.
     */
    @GetMapping( path = "/status/{userName}")
    Integer getStatus(@PathVariable String userName) {
        return queueManager.getStatus(userName);
    }

    /**
     * this method is for adding a user to the Queue. If the user is added, it means it is registered.
     * @param userName
     *              the id of the user.
     */
    @PostMapping( path = "/add/{userName}" )
    public void addUserToQueue(@PathVariable String userName) {
        queueManager.add(userName);
    }
}
