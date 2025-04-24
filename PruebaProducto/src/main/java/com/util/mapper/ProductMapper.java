package com.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dto.ProductDto;
import com.persistence.entity.Product;

@Mapper
public interface ProductMapper {
    
    ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    Product productDtoToproduct(ProductDto product);
    ProductDto productToProductDto(Product product);
}
