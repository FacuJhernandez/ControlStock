package com.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persistence.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale,Long> {

    
}
