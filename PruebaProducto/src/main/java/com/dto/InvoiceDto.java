package com.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvoiceDto{
    
    private Long invoiceNumber;
    private LocalDate date;
    private double total;

    private SaleDto sale;
}
