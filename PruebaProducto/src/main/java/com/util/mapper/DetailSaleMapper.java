package com.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.DetailSaleDto;
import com.persistence.entity.DetailSale;

@Mapper
public interface DetailSaleMapper {

    DetailSaleMapper mapper=  Mappers.getMapper(DetailSaleMapper.class);

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "product.cost", target= "unitPrice")
    DetailSaleDto detailProductToDetailProductDto(DetailSale detail);



    
}
