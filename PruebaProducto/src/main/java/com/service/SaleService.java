package com.service;

import java.util.List;

import com.dto.SaleDto;

public interface SaleService {
    
    public SaleDto getSale(Long id);
    public List<SaleDto> getSaleAll();
    public SaleDto saveSale(SaleDto sale);
    public void cancelSale(Long id);
    public void descancelSale(Long id);
    public void deleteSale(Long id);
}
