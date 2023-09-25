package com.example.exception;

public class DifferentAccountPostingException extends RuntimeException {
    public DifferentAccountPostingException(String emsg, Throwable err){
        super(emsg, err);
    }
}
