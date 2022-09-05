package com.codegym.service.impl.employee;

import com.codegym.model.employee.Position;
import com.codegym.repository.employee.IPositionRepository;
import com.codegym.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {

    @Autowired
    private IPositionRepository iPositionRepository;

    @Override
    public List<Position> findAll() {
        return this.iPositionRepository.findAll();
    }
}
