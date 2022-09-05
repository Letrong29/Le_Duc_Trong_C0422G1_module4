package com.codegym.service.impl.customer;

import com.codegym.model.customer.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAllByNameContaining(String nameCustomer, Pageable pageable) {
        return this.iCustomerRepository.findAllByNameContaining(nameCustomer, pageable);
    }

    @Override
    public void save(Customer customer) {
        this.iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return this.iCustomerRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        this.iCustomerRepository.deleteById(id);
    }
}
