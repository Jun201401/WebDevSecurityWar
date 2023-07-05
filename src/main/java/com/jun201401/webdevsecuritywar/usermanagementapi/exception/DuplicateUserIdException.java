package com.jun201401.webdevsecuritywar.usermanagementapi.exception;

public class DuplicateUserIdException extends RuntimeException {
    public DuplicateUserIdException(String message)  {
        super(message);
    }
}
