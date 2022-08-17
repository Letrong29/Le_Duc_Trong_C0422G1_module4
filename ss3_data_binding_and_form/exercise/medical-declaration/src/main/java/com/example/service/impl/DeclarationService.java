package com.example.service.impl;

import com.example.model.MedicalDeclaration;
import com.example.repository.IDeclarationRepository;
import com.example.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationService implements IDeclarationService {

    @Autowired
    private IDeclarationRepository iDeclarationRepository;

    @Override
    public List<Integer> showYearOfBirthList() {
        return this.iDeclarationRepository.showYearOfBirthList();
    }

    @Override
    public List<String> showGenderList() {
        return this.iDeclarationRepository.showGenderList();
    }

    @Override
    public List<String> showVehiclesList() {
        return this.iDeclarationRepository.showVehiclesList();
    }

    @Override
    public List<Integer> showDayList() {
        return this.iDeclarationRepository.showDayList();
    }

    @Override
    public List<Integer> showMonthList() {
        return this.iDeclarationRepository.showMonthList();
    }

    @Override
    public List<Integer> showYearList() {
        return this.iDeclarationRepository.showYearList();
    }

    @Override
    public void addNew(MedicalDeclaration medicalDeclaration) {
        this.iDeclarationRepository.addNew(medicalDeclaration);
    }

    @Override
    public List<MedicalDeclaration> findAll() {
        return this.iDeclarationRepository.findAll();
    }

    @Override
    public MedicalDeclaration findById(int id) {
        return this.iDeclarationRepository.findById(id);
    }

    @Override
    public void update(int id, MedicalDeclaration medicalDeclaration) {
        this.iDeclarationRepository.update(id, medicalDeclaration);
    }


}
