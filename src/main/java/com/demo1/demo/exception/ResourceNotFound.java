package com.demo1.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NO_CONTENT)
public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(String message){
        super( message);
    }
}
