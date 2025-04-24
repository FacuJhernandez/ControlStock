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

import com.dto.ProductDto;
import com.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> getProduct( @PathVariable Long id){
        return new ResponseEntity<>(productService.getProduct(id),HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getProductAll( ){
        return new ResponseEntity<>(productService.getProductAll(),HttpStatus.OK);
    }
    
    @PostMapping("/product")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto product){
        return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.CREATED);

    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductDto product){
        return new ResponseEntity<>(productService.updateProduct(id,product),HttpStatus.OK);

    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<ProductDto> deleteProduct( @PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
