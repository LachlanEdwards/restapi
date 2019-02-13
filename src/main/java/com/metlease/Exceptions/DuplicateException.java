package com.metlease.Exceptions;

public class DuplicateException extends Exception {
    public DuplicateException(String message) {
        super(message);
        System.err.println(message);
    }
}
