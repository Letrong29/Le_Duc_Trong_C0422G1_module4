package com.example.service.impl;

import com.example.repository.ICondimentsRepository;
import com.example.service.ICondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondimentsService implements ICondimentsService {

    @Autowired
    private ICondimentsRepository iCondimentsRepository;

    @Override
    public List<String> findALl() {
        return this.iCondimentsRepository.findALl();
    }
}
