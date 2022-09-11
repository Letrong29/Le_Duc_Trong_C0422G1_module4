package com.codegym.dto.facility;

import com.codegym.common.facility.FacilityValidate;
import com.codegym.dto.contract.ContractDto;
import com.codegym.model.facility.Facility;
import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

public class FacilityDto implements Validator {

    private String name;

    private String area;

    private String cost;

    private String maxPeople;

    private String standard;

    private String otherConvenience;

    private String poolArea;

    private String floors;

    private String facilityFree;

    private RentType rentType;

    private FacilityType facilityType;

    public FacilityDto() {
    }

    public FacilityDto(String name, String area, String cost, String maxPeople, String standard, String otherConvenience, String poolArea, String floors, String facilityFree, RentType rentType, FacilityType facilityType) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standard = standard;
        this.otherConvenience = otherConvenience;
        this.poolArea = poolArea;
        this.floors = floors;
        this.facilityFree = facilityFree;
        this.rentType = rentType;
        this.facilityType = facilityType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getOtherConvenience() {
        return otherConvenience;
    }

    public void setOtherConvenience(String otherConvenience) {
        this.otherConvenience = otherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;

        FacilityValidate.checkName(facilityDto, errors);

        FacilityValidate.checkArea(facilityDto, errors);

        FacilityValidate.checkCost(facilityDto, errors);

        FacilityValidate.checkMaxPeople(facilityDto, errors);

        FacilityValidate.checkPoolArea(facilityDto, errors);

        FacilityValidate.checkFloors(facilityDto, errors);
    }
}
