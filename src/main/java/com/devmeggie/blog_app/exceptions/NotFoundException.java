package com.devmeggie.blog_app.exceptions;

public class NotFoundException extends RuntimeException{

    private String message;

    NotFoundException() {
        this.message = "Not found";
    }

    NotFoundException(String msg){
        super(msg);
        this.message=msg;
    }
}
