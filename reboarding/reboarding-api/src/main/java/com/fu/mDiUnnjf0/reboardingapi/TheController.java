package com.fu.mDiUnnjf0.reboardingapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fu.mDiUnnjf0.reboardingapi.businesslogic.RegisterManager;
import com.fu.mDiUnnjf0.reboardingapi.dto.RegisterResponse;

@RestController
public class TheController {

    @Autowired
    private RegisterManager registerManager;

    /**
     * This method is for user registration.
     * 
     * @param userName
     *            the id of the user
     * @return the RegisterResponse contains the result of the registration
     */
    @PostMapping("/register")
    public RegisterResponse register(@PathVariable final String userName) {
        return registerManager.register(userName);
    }

    /**
     * This method is for requesting the waiting list index of the given user.
     * If the user is not on the waiting list it will response with http code
     * 412 Precondition Failed
     * 
     * @param userName
     *            the id of the user
     * @return the RegisterResponse contains the result of the registration
     */
    @GetMapping("/status")
    Integer status(@PathVariable final String userName) {
        // TODO throw UserStatusException for the http code
        return null;
    }

    /**
     * This method will entry the user. If the user can entry (it is allowed by
     * his waiting list position) save his entry to the db and will return true.
     * If the user can't entry because the waiting list before he is too long
     * then it will return false. If the user can't entry because he is not on
     * the waiting list it will response with http code 412 Precondition Failed.
     * 
     * @param userName
     *            the id of the user
     * @return the RegisterResponse contains the result of the registration
     */
    @PostMapping("/entry")
    boolean entry(@PathVariable final String userName) {
        // TODO
        return false;
    }

    /**
     * This method will exit the user, update the position in the db. If the
     * user wasn't in the building according the database, the method will
     * response with http code 412 Precondition Failed.
     * 
     * @param userName
     *            the id of the user
     * @return the RegisterResponse contains the result of the registration
     */
    @PostMapping("/exit")
    void exit(@PathVariable final String userName) {
        // TODO
    }

}
