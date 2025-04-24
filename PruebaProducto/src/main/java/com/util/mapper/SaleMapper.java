package com.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dto.SaleDto;
import com.persistence.entity.Sale;

@Mapper(uses = {DetailSaleMapper.class})
public interface SaleMapper {
    
    SaleMapper mapper = Mappers.getMapper(SaleMapper.class);

    Sale saleDtoToSale (SaleDto sale);
    SaleDto saleToSaledto(Sale sale);

}
