package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundSaleException extends RuntimeException {

    private String message;

    public NotFoundSaleException(){
        this.message = "Sale not found";
    }

}
