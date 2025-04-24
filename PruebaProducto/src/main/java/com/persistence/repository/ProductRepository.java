package com.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persistence.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
    
}
