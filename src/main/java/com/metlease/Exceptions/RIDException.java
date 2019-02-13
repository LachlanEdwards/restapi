package com.metlease.Exceptions;

public class RIDException extends Exception {
    public RIDException(String message) {
        super(message);
        System.err.println(message);
    }
}
