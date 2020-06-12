package com.fu.mDiUnnjf0.reboardingapi.dto;

import lombok.Data;

@Data
public class RegisterResponse {

    /**
     * is true if the requested user is fitted in the current limit
     * is false if the user is added to the waiting list
     */
    private boolean succeed;
    /**
     * if the request was succeed then this value will be null
     * otherwise it will contain the index on the waiting list of the given user
     */
    private Integer waitingListIndex;

}
