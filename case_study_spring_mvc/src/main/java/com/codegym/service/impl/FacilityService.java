package com.codegym.service.impl;

import com.codegym.model.Facility;
import com.codegym.repository.IFacilityRepository;
import com.codegym.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> findAllByNameContaining(String nameFacility, Pageable pageable) {
        return this.iFacilityRepository.findAllByNameContaining(nameFacility, pageable);
    }

    @Override
    public void save(Facility facility) {
        this.iFacilityRepository.save(facility);
    }

    @Override
    public Facility findById(int id) {
        return this.iFacilityRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        this.iFacilityRepository.deleteById(id);
    }

}
