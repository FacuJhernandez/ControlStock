package com.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.InvoiceDto;
import com.exception.NoFoundInvoiceException;
import com.persistence.entity.Invoice;
import com.persistence.entity.Sale;
import com.persistence.repository.InvoiceRepository;
import com.service.InvoiceService;
import com.util.mapper.InvoiceMapper;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public List<InvoiceDto> getAll() {
        List<InvoiceDto> response = invoiceRepository.findAll().stream()
                                    .map(invoice -> InvoiceMapper.mapper.invoiceToInvoiceDto(invoice))
                                    .collect(Collectors.toList());
        return response;
    }

    @Override
    public InvoiceDto getInvoiceId(Long id) {
        return InvoiceMapper.mapper.invoiceToInvoiceDto(invoiceRepository.findById(id).orElseThrow(() -> new NoFoundInvoiceException()));
    }

    @Override
    public InvoiceDto getInvoiceDtoBySaleId(Long id) {
        Invoice response = invoiceRepository.findBySaleId(id).orElseThrow(()-> new NoFoundInvoiceException());
        return InvoiceMapper.mapper.invoiceToInvoiceDto(response);
    }

    @Override
    public Invoice saveInvoice(Sale sale) {
        Invoice invoice = new Invoice();
        invoice.setDate(sale.getDate());
        invoice.setTotal(sale.getValor());
        invoice.setSale(sale);
        invoice.setInvoiceNumber(generarNumero());

        return invoiceRepository.save(invoice);
        
    }

    private Long generarNumero() {
        Long maxNumber = invoiceRepository.findMaxInvoiceNumber();
        return (maxNumber != null) ? maxNumber  + 1 : 1L; 
    }
    
}
