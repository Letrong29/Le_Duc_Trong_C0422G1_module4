package com.example.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "employee")
@DiscriminatorValue("employee")
public class Employee extends Person{

    @Column
    private String salary;

    public Employee(String salary) {
        this.salary = salary;
    }

    public Employee(int id, String name, String salary) {
        super(id, name);
        this.salary = salary;
    }

    public Employee() {

    }
}
