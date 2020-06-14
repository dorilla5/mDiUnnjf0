package com.fu.mDiUnnjf0.queue.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.PRECONDITION_FAILED)
public class UserNameNotFoundException extends RuntimeException {
}
