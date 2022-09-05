package com.example.backend.repository;

import com.example.backend.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartphoneRepository extends JpaRepository<Smartphone, Integer> {

    Page<Smartphone> findAllByProducerContaining(Pageable pageable, String keySearch);
}
