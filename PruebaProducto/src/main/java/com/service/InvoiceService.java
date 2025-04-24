package com.service;

import java.util.List;

import com.dto.InvoiceDto;
import com.persistence.entity.Invoice;
import com.persistence.entity.Sale;

public interface InvoiceService {

    public List<InvoiceDto> getAll();

    public InvoiceDto getInvoiceId(Long id);

    public InvoiceDto getInvoiceDtoBySaleId(Long id);

    public Invoice saveInvoice(Sale sale);

    
}
