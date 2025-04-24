package com.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.persistence.entity.Invoice;


public interface InvoiceRepository extends JpaRepository<Invoice,Long> {


    public Optional<Invoice> findBySaleId(Long id);

    @Query("Select MAX(i.invoiceNumber) from Invoice i")
    Long findMaxInvoiceNumber();
    
}
