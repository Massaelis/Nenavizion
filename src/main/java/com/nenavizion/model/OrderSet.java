package com.nenavizion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
public class OrderSet {

    @Id
    private String id;

    private int count;

    private BigDecimal priceOrderSet;

    @OneToOne
    private Jewelry jewelry;
}

