package com.metlease.Exceptions;

import com.metlease.Entity.Helpers.HTTP.Error404;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public Error404 ResourceNotFoundException() {
        return new Error404();
    }
}
