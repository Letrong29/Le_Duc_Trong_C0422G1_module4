package com.codegym.dto.contract;

import com.codegym.dto.customer.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;

import java.util.List;

public class ContractDto {

    private int id;

    private String startDate;

    private String endDate;

    private double deposit;

    private Employee employeeId;

    private CustomerDto customerId;

    private Facility facilityId;

    private List<ContractDetailDto> contractDetails;

    public ContractDto() {
    }

    public ContractDto(int id, String startDate, String endDate, double deposit, Employee employeeId, CustomerDto customerId, Facility facilityId, List<ContractDetailDto> contractDetails) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.facilityId = facilityId;
        this.contractDetails = contractDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public CustomerDto getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerDto customerId) {
        this.customerId = customerId;
    }

    public Facility getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Facility facilityId) {
        this.facilityId = facilityId;
    }

    public List<ContractDetailDto> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetailDto> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
