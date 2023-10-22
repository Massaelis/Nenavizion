package com.nenavizion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Client {
    @Id
    private String email;

    private String name;

    private String pass;
}