package com.example.exception;

public class MessageNotExistsException extends Exception{
    public MessageNotExistsException(String emsg, Throwable err){
        super(emsg, err);
    }
}
