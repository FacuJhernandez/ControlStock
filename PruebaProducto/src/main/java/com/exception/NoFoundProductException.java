package com.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import lombok.Getter;


@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class NoFoundProductException extends RuntimeException {
    
    private String message;

    public NoFoundProductException(){
        this.message = "Product not found";
    }


}
