package com.metlease.Exceptions;

public class SIDException extends Exception {
    public SIDException(String message) {
        super(message);
        System.err.println(message);
    }
}
