package com.example.backend.service.impl;

import com.example.backend.model.Smartphone;
import com.example.backend.repository.ISmartphoneRepository;
import com.example.backend.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService {

    @Autowired
    private ISmartphoneRepository iSmartphoneRepository;

    @Override
    public Page<Smartphone> findAll(Pageable pageable, String keySearch) {
        return this.iSmartphoneRepository.findAllByProducerContaining(pageable, keySearch);
    }

    @Override
    public Optional<Smartphone> findById(int id) {
        return this.iSmartphoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return this.iSmartphoneRepository.save(smartphone);
    }

    @Override
    public void remove(Smartphone smartphone) {
        this.iSmartphoneRepository.delete(smartphone);
    }
}
