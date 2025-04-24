package com.util.mapper;

import com.dto.ProductDto;
import com.persistence.entity.Product;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-24T00:19:28-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product productDtoToproduct(ProductDto product) {
        if ( product == null ) {
            return null;
        }

        Product product1 = new Product();

        product1.setCant( product.getCant() );
        product1.setCost( product.getCost() );
        product1.setDescription( product.getDescription() );
        product1.setId( product.getId() );
        product1.setName( product.getName() );

        return product1;
    }

    @Override
    public ProductDto productToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        int cant = 0;
        double cost = 0.0d;
        String description = null;
        Long id = null;
        String name = null;

        cant = product.getCant();
        cost = product.getCost();
        description = product.getDescription();
        id = product.getId();
        name = product.getName();

        ProductDto productDto = new ProductDto( id, name, description, cost, cant );

        return productDto;
    }
}
