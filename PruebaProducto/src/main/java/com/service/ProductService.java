package com.service;



import java.util.List;

import com.dto.ProductDto;


public interface ProductService {
    
    public ProductDto saveProduct(ProductDto product);

    public ProductDto getProduct(Long id);

    public List<ProductDto> getProductAll();

    public ProductDto updateProduct(Long id, ProductDto product);

    public void deleteProduct(Long id);

    public void descontStock(Long id, int cant);
}
