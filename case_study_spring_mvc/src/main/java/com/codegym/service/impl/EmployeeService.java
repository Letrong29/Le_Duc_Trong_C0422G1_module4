package com.codegym.service.impl;

import com.codegym.model.Employee;
import com.codegym.repository.IEmployeeRepository;
import com.codegym.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAllByNameContaining(String nameEmployee, Pageable pageable) {
        return this.iEmployeeRepository.findAllByNameContaining(nameEmployee, pageable);
    }

    @Override
    public void save(Employee employee) {
        this.iEmployeeRepository.save(employee);
    }
}
