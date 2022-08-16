package com.customerManagement.service;

import com.customerManagement.model.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> showList();

    Customer findCustomerById(int id);
}
