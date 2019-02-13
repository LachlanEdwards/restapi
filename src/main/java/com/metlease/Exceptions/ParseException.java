package com.metlease.Exceptions;

public class ParseException extends Exception {
    public ParseException(String message) {
        super(message);
        System.err.println(message);
    }
}
