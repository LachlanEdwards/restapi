package com.metlease.Entity.Helpers.HTTP;

public class Error404 extends Error {
    @Override
    public Integer getError() {
        return 404;
    }

    @Override
    public String getDescription() {
        return "The server couldn't locate the file or directory you requested. The file or directory you are looking for might have been removed, had its name changed or is temporarily unavailable.";
    }

    @Override
    public String getUrl() {
        return "/404";
    }

    @Override
    public String getNext() {
        return "redirect";
    }
}
