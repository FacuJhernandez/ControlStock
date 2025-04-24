package com.util.mapper;

import com.dto.InvoiceDto;
import com.dto.SaleDto;
import com.persistence.entity.Invoice;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-24T00:19:27-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
public class InvoiceMapperImpl implements InvoiceMapper {

    private final SaleMapper saleMapper = Mappers.getMapper( SaleMapper.class );

    @Override
    public InvoiceDto invoiceToInvoiceDto(Invoice invoice) {
        if ( invoice == null ) {
            return null;
        }

        LocalDate date = null;
        Long invoiceNumber = null;
        SaleDto sale = null;
        double total = 0.0d;

        date = invoice.getDate();
        invoiceNumber = invoice.getInvoiceNumber();
        sale = saleMapper.saleToSaledto( invoice.getSale() );
        total = invoice.getTotal();

        InvoiceDto invoiceDto = new InvoiceDto( invoiceNumber, date, total, sale );

        return invoiceDto;
    }
}
