package com.fu.mDiUnnjf0.office.controller;

import com.fu.mDiUnnjf0.office.businessLogic.OfficeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class OfficeController {

    @Autowired
    private OfficeManager officeManager;

    /**
     * A user enters the office.
     * @param userName: name of the user.
     */
    @PostMapping( path = "/enter/{userName}" )
    public void enter(@PathVariable String userName) {
        officeManager.enter(userName);
    }

    /**
     * A user exits from the office.
     * @param userName: name of the user.
     */
    @PostMapping( path = "/exit/{userName}" )
    public void exit(@PathVariable String userName) {
        officeManager.exit(userName);
    }

    /**
     * A user is in the office or not.
     * @param userName: the name of the user.
     * @return
     */
    @GetMapping( path = "/staysin/{userName}")
    Boolean staysIn(@PathVariable String userName) {
        return officeManager.isInTheOffice(userName);
    }

    /**
     * How many people stays in the office.
     * @return How many people stays in the office.
     */
    @GetMapping( path = "/staysin")
    Integer countPeople() {
        return officeManager.countPersonsInTheOffice();
    }

}
