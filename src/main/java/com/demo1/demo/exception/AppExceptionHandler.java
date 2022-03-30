package com.demo1.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFound ex, WebRequest request){
        return  new ResponseEntity<Object>(new ApiError(ex.getMessage(), HttpStatus.NO_CONTENT, LocalDateTime.now()),HttpStatus.NO_CONTENT);
    }
}
