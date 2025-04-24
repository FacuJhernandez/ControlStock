package com.persistence.entity;

import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;
    private double valor;
    private LocalDate date;
    @Column(name = "is_canceled", nullable = false)
    private boolean isCanceled = false;
    private String estado;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<DetailSale> details;


}
