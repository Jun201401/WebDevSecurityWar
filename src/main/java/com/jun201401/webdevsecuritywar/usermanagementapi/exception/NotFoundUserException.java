package com.jun201401.webdevsecuritywar.usermanagementapi.exception;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException(String userId) {
        super(String.format("The User corresponding to the ID = %s does not exist", userId));
    }
}