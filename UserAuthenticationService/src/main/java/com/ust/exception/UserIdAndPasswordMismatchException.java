package com.ust.exception;

public class UserIdAndPasswordMismatchException extends Exception {

    public UserIdAndPasswordMismatchException(String message) {
        super(message);
    }
}