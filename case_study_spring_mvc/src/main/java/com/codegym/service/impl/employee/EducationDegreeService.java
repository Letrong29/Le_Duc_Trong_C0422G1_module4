package com.codegym.service.impl.employee;

import com.codegym.model.employee.EducationDegree;
import com.codegym.repository.employee.IEducationDegreeRepository;
import com.codegym.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {

    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return this.iEducationDegreeRepository.findAll();
    }
}
