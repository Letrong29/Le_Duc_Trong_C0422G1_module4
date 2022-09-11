package com.codegym.dto.contract;

import javax.persistence.*;
import java.util.List;

public class AttachFacilityDto {

    private int id;

    private String name;

    private double cost;

    private String unit;

    private String status;

    private List<ContractDetailDto> contractDetails;

    public AttachFacilityDto() {
    }

    public AttachFacilityDto(int id, String name, double cost, String unit, String status, List<ContractDetailDto> contractDetails) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contractDetails = contractDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContractDetailDto> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetailDto> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
