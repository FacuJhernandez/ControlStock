package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoFoundInvoiceException extends RuntimeException {

    String message;

    public NoFoundInvoiceException(){
        this.message= "Invoice not found";
    }
    
}
