package com.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DetailSaleDto {
    
    private Long productId;
    private String productName;
    private int cantProduct;
    private double unitPrice;
    
}
