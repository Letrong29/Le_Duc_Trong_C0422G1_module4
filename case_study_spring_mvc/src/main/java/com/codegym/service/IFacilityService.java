package com.codegym.service;

import com.codegym.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {

    Page<Facility> findAllByNameContaining(String nameFacility, Pageable pageable);

    void save(Facility facility);

    Facility findById(int id);

    void deleteById(int id);
}
