package com.customerManagement.service.impl;

import com.customerManagement.model.Customer;
import com.customerManagement.repository.ICustomerRepository;
import com.customerManagement.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> showList() {
        return this.iCustomerRepository.showList();
    }

    @Override
    public Customer findCustomerById(int id) {
        return iCustomerRepository.findCustomerById(id);
    }
}
