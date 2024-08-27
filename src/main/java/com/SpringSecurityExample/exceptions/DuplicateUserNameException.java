package com.SpringSecurityExample.exceptions;

public class DuplicateUserNameException extends RuntimeException{
    public DuplicateUserNameException(String message){
        super(message);
    }
}
