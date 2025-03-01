package com.example.demo.exception;

public class UserNotFoundException extends BaseAppException {
    public UserNotFoundException(String message) {
        super(message);
        responseCode = 404;
    }
}
