package com.dto;

import java.time.LocalDate;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SaleDto {
    
    private Long id;
    private double valor;
    private LocalDate date;
    private boolean isCanceled;
    private String estado;
    private List<DetailSaleDto> details;
}
