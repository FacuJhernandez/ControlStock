package com.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.ProductDto;
import com.exception.NoFoundProductException;
import com.persistence.entity.Product;
import com.persistence.repository.ProductRepository;
import java.util.List;
import java.util.stream.Collectors;

import com.service.ProductService;
import com.util.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto saveProduct(ProductDto producto) {
      Product product = productRepository.save(ProductMapper.mapper.productDtoToproduct(producto));
      return ProductMapper.mapper.productToProductDto(product);

    }

    @Override
    public ProductDto getProduct(Long id) {
        Product response = productRepository.findById(id).orElseThrow(()-> new NoFoundProductException());
        return ProductMapper.mapper.productToProductDto(response);

    }

    @Override
    public List<ProductDto> getProductAll() {
        List<ProductDto> response = productRepository.findAll().stream()
                                    .map(product -> ProductMapper.mapper.productToProductDto(product))
                                    .collect(Collectors.toList());

      return response;
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto product) {
      Product response = productRepository.findById(id).orElseThrow(()-> new NoFoundProductException());
      response.setName(product.getName());
      response.setCant(product.getCant());
      response.setCost(product.getCost());
      response.setDescription(product.getDescription());
      
      productRepository.save(response);

      return ProductMapper.mapper.productToProductDto(response);
    }

    @Override
    public void deleteProduct(Long id) {
      productRepository.delete(productRepository.findById(id).orElseThrow(() -> new NoFoundProductException()));
    }

    @Override
    public void descontStock(Long id, int cant) {
      Product product = productRepository.findById(id).orElseThrow(()-> new NoFoundProductException());

      if(product.getCant() - cant < 0){ 
      }
      product.setCant(product.getCant()- cant);

      productRepository.save(product);
    }  
    
}
