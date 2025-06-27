package com.smatech.auth_service.exeptions;

public class UnexpectedErrorException extends RuntimeException {
    public UnexpectedErrorException(String exception) {
        super(exception);
    }
}
