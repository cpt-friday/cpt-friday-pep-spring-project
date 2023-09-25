package com.example.exception;

public class InvalidContentsException extends RuntimeException{
    public InvalidContentsException(String emsg, Throwable err){
        super(emsg, err);
    }
}
