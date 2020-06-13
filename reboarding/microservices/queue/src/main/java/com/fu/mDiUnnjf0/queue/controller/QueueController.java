package com.fu.mDiUnnjf0.queue.controller;

import com.fu.mDiUnnjf0.queue.businessLogic.QueueManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class QueueController {

    @Autowired
    private QueueManager queueManager;

    @GetMapping( path = "/status/{userName}")
    Integer getStatus(@PathVariable String userName) {
        return queueManager.getStatus(userName);
    }

    @DeleteMapping( "/delete/{userName}")
    void delete(@PathVariable String userName) {
        queueManager.delete(userName);
    }

    @PostMapping( path = "/add/{userName}" )
    public void add(@PathVariable String userName) {
        queueManager.add(userName);
    }
}
