package com.loremipsum.moneysense.controllers.auth.exception;

import org.springframework.security.core.AuthenticationException;

public class EmailAreBusyException extends AuthenticationException {
    public EmailAreBusyException(String msg) {
        super(msg);
        System.err.println("Email are busy");
    }
}
