package com.devmeggie.blog_app.exceptions;

import com.devmeggie.blog_app.pojos.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiResponse handleNotFoundException(NotFoundException ex){
        return new ApiResponse(ex.getMessage(),HttpStatus.NOT_FOUND.value(), null);
    }

    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    @ResponseBody
    public ApiResponse handlerAlreadyExistException(NotFoundException ex){
        return new ApiResponse(ex.getMessage(),HttpStatus.CONFLICT.value(), null);
    }


}
