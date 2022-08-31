package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return this.iCustomerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(int id) {
        return this.iCustomerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return this.iCustomerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        this.iCustomerRepository.deleteById(id);
    }
}
