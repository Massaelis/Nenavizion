package com.nenavizion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

//@Entity
@Getter
@Setter
public class Ordering {
    @Id
    private String id;

    private Date created;

    @OneToOne
    private Client client;

    @OneToMany
    private Set<OrderSet> orderSet;
}
