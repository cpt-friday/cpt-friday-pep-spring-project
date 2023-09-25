package com.example.exception;

public class AccountNotExistsException extends Exception{
    public AccountNotExistsException(String emsg, Throwable err){
        super(emsg, err);
    }
}
