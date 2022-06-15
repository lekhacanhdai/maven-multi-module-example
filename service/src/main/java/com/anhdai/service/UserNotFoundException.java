package com.anhdai.service;

public class UserNotFoundException extends RuntimeException{
    private static final long serialVersionUID = -3891534644498426670L;
    public UserNotFoundException(String message){
        super(message);
    }
}
