package com.codegym.repository.facility;

import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {

    Page<Facility> findAllByNameContaining(String nameFacility,Pageable pageable);

}
