package org.aibles.training.userservices.Exception;

import org.springframework.http.HttpStatus;

public class UserExistsException extends AbstractException{
    public UserExistsException() {
        super("User Already Exists", HttpStatus.CONFLICT);
    }
}
