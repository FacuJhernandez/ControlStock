package com.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dto.InvoiceDto;
import com.persistence.entity.Invoice;

@Mapper(uses = {DetailSaleMapper.class, SaleMapper.class})
public interface InvoiceMapper {
    
    InvoiceMapper mapper = Mappers.getMapper(InvoiceMapper.class);

    InvoiceDto invoiceToInvoiceDto(Invoice invoice);

}
