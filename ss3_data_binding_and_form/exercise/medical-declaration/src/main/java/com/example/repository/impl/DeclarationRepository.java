package com.example.repository.impl;

import com.example.model.MedicalDeclaration;
import com.example.repository.IDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DeclarationRepository implements IDeclarationRepository {

    private static List<Integer> yearOfBirthList = new ArrayList<>();
    private static List<String> genderList = new ArrayList<>();
    private static List<String> vehiclesList = new ArrayList<>();
    private static List<Integer> dayList = new ArrayList<>();
    private static List<Integer> monthList = new ArrayList<>();
    private static List<Integer> yearList = new ArrayList<>();
    private Map<Integer, MedicalDeclaration> medicalDeclarationMap = new HashMap<>();

    static {

        for (int i = 1970; i < 2022; i++) {
            yearOfBirthList.add(i);
        }

        genderList.add("Nam");
        genderList.add("Nu");

        vehiclesList.add("Tau bay");
        vehiclesList.add("Tau thuyen");
        vehiclesList.add("O to");
        vehiclesList.add("Khac(ghi ro)");

        for (int i = 1; i < 32; i++) {
            dayList.add(i);
        }

        for (int i = 1; i < 13; i++) {
            monthList.add(i);
        }

        for (int i = 2019; i < 2023; i++) {
            yearList.add(i);
        }
    }

    @Override
    public List<Integer> showYearOfBirthList() {
        return yearOfBirthList;
    }

    @Override
    public List<String> showGenderList() {
        return genderList;
    }

    @Override
    public List<String> showVehiclesList() {
        return vehiclesList;
    }

    @Override
    public List<Integer> showDayList() {
        return dayList;
    }

    @Override
    public List<Integer> showMonthList() {
        return monthList;
    }

    @Override
    public List<Integer> showYearList() {
        return yearList;
    }

    @Override
    public void addNew(MedicalDeclaration medicalDeclaration) {
        medicalDeclaration.setId((int) (Math.random() * 1000));
        medicalDeclarationMap.put(medicalDeclaration.getId(), medicalDeclaration);
    }

    @Override
    public List<MedicalDeclaration> findAll() {
        return new ArrayList<>(medicalDeclarationMap.values());
    }

    @Override
    public MedicalDeclaration findById(int id) {
        return medicalDeclarationMap.get(id);
    }

    @Override
    public void update(int id, MedicalDeclaration medicalDeclaration) {
        medicalDeclarationMap.put(id, medicalDeclaration);
    }


}
