package com.example.service;

import com.example.model.MedicalDeclaration;

import java.util.List;

public interface IDeclarationService {

    List<Integer> showYearOfBirthList();

    List<String> showGenderList();

    List<String> showVehiclesList();

    List<Integer> showDayList();

    List<Integer> showMonthList();

    List<Integer> showYearList();

    void addNew(MedicalDeclaration medicalDeclaration);

    List<MedicalDeclaration> findAll();

    MedicalDeclaration findById(int id);

    void update(int id, MedicalDeclaration medicalDeclaration);
}
