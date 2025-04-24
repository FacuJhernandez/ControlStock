package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.SaleDto;
import com.service.SaleService;




@RestController
public class SaleController {
    
    @Autowired
    private SaleService saleService;


    @GetMapping("/sale/{id}")
    public ResponseEntity<SaleDto> getSale (@PathVariable Long id){
        return new ResponseEntity<>(saleService.getSale(id),HttpStatus.OK);
    }

    @GetMapping("/sales")
    public ResponseEntity<List<SaleDto>> getSaleAll (){
        return new ResponseEntity<>(saleService.getSaleAll(),HttpStatus.OK);
    }

    @PostMapping("/sale")
    public ResponseEntity<SaleDto> saveSale(@RequestBody SaleDto sale){
        return new ResponseEntity<>(saleService.saveSale(sale),HttpStatus.CREATED);
    }


    @DeleteMapping("/sale/{id}")
    public ResponseEntity<SaleDto> deleteSale (@PathVariable Long id){
        saleService.deleteSale(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/sale/{id}/canceled")
    public ResponseEntity<String> canceledSale (@PathVariable Long id){
        saleService.cancelSale(id);
        return ResponseEntity.ok("Venta anulada exitosamente");
    }

    @PutMapping("/sale/{id}/descanceled")
    public ResponseEntity<String> descanceledSale (@PathVariable Long id){
        saleService.descancelSale(id);
        return ResponseEntity.ok("Venta descancelada exitosamente");
    }


}
