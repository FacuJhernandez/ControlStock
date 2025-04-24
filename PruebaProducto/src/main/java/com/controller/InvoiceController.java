package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dto.InvoiceDto;
import com.service.InvoiceService;



@Controller
public class InvoiceController {
    
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/invoices")
    public ResponseEntity<List<InvoiceDto>> getInvoiceAll(){
        return new ResponseEntity<>(invoiceService.getAll(),HttpStatus.OK);

    }

    @GetMapping("/invoice/{id}")
    public ResponseEntity<InvoiceDto> getInvoiceById( @PathVariable Long id){
        return new ResponseEntity<>(invoiceService.getInvoiceId(id),HttpStatus.OK);

    } 

    @GetMapping("/invoice/sale/{id}")
    public ResponseEntity<InvoiceDto> getInvoiceBySaleId( @PathVariable Long id){
        return new ResponseEntity<>(invoiceService.getInvoiceDtoBySaleId(id),HttpStatus.OK);

    } 



}
