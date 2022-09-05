package com.codegym.service;

import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {

    Page<Employee> findAllByNameContaining(String nameEmployee, Pageable pageable);

    void save(Employee employee);
}
