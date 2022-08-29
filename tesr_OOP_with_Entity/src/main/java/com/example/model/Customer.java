package com.example.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "customer")
@DiscriminatorValue("customer")
public class Customer extends Person{

    @Column
    private String address;

    public Customer(String address) {
        this.address = address;
    }

    public Customer(int id, String name, String address) {
        super(id, name);
        this.address = address;
    }

    public Customer() {

    }
}
