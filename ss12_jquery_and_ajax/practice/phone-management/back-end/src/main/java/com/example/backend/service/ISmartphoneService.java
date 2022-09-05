package com.example.backend.service;

import com.example.backend.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISmartphoneService {

    Page<Smartphone> findAll(Pageable pageable, String keySearch);

    Optional<Smartphone> findById(int id);

    Smartphone save(Smartphone smartphone);

    void remove(Smartphone smartphone);
}
