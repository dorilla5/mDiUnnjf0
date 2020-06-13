package com.fu.mDiUnnjf0.queue.controller;

import com.fu.mDiUnnjf0.queue.businessLogic.StatusManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin( origins = "*", allowedHeaders = "*")
@RestController
public class QueueController {

    @Autowired
    private StatusManager statusManager;

    @GetMapping( path = "/status", consumes = "application/json", produces = "application/json")
    Integer getStatus(@RequestBody String username) {
        return statusManager.getStatus(username);
    }
}
