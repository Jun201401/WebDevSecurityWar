package com.jun201401.webdevsecuritywar.usermanagementapi.exception;

public class NotFoundAuthorityException extends RuntimeException {
    public NotFoundAuthorityException(String message)  {
        super(message);
    }
}
