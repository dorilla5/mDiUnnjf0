package com.fu.mDiUnnjf0.reboardingapi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class UserStatusException extends RuntimeException {

    public UserStatusException() {
        // TODO Auto-generated constructor stub
    }

    public UserStatusException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public UserStatusException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public UserStatusException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public UserStatusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

}
