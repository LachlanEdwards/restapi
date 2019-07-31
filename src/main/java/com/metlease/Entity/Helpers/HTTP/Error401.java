package com.metlease.Entity.Helpers.HTTP;

public class Error401 extends Error {
    @Override
    public Integer getError() {
        return 401;
    }

    @Override
    public String getDescription() {
        return "The request has not been applied because it lacks valid authentication credentials for the target resource.";
    }

    @Override
    public String getUrl() {
        return "/401";
    }

    @Override
    public String getNext() {
        return "redirect";
    }
}
