package com.customerManagement.repository;

import com.customerManagement.model.Customer;

import java.util.List;

public interface ICustomerRepository {

    List<Customer> showList();

    Customer findCustomerById(int id);
}
