package com.fu.mDiUnnjf0.reboardingapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class UserStatusException extends RuntimeException {

    public UserStatusException() {
        // TODO Auto-generated constructor stub
    }

    public UserStatusException(final String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public UserStatusException(final Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public UserStatusException(final String message, final Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public UserStatusException(final String message, final Throwable cause, final boolean enableSuppression,
            final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

}
