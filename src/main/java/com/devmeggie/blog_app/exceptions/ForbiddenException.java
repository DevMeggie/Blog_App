package com.devmeggie.blog_app.exceptions;

public class ForbiddenException extends RuntimeException {

    private final String message;

    public ForbiddenException() {
        super("Sorry! you do not have access");
        this.message = "Sorry! you do not have access";
    }
}

