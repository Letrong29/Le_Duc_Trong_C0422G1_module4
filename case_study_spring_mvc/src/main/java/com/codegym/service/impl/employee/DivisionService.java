package com.codegym.service.impl.employee;

import com.codegym.model.employee.Division;
import com.codegym.repository.employee.IDivisionRepository;
import com.codegym.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {

    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> findAll() {
        return this.iDivisionRepository.findAll();
    }
}
