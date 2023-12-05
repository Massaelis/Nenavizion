package com.nenavizion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Order {
    @Id
    private String id;

    private Client client;

    private Set<OrderSet> orderSet;
}
