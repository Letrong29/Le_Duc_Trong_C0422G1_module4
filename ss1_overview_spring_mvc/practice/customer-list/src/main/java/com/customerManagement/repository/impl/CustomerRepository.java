package com.customerManagement.repository.impl;

import com.customerManagement.model.Customer;
import com.customerManagement.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(0, "T", "t@codegym", "Da Nang"));
        customerList.add(new Customer(1, "Nhat", "nhat@codegym", "Quang Tri"));
        customerList.add(new Customer(2, "Trang", "trang@codegym", "Ha noi"));
        customerList.add(new Customer(3, "Nguyen Binh Son", "son@codegym", "Sai Gon"));
        customerList.add(new Customer(4, "Dang Xuan Hoa", "hoa@codegym", "Da Nang"));
    }


    @Override
    public List<Customer> showList() {
        return customerList;
    }

    @Override
    public Customer findCustomerById(int id) {

        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}
