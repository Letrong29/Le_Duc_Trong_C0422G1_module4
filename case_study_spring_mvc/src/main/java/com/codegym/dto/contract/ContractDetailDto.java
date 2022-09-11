package com.codegym.dto.contract;

public class ContractDetailDto {

    private int id;

    private int quantity;

    private ContractDto contractId;

    private AttachFacilityDto attachFacilityId;

    public ContractDetailDto() {
    }

    public ContractDetailDto(int id, int quantity, ContractDto contractId, AttachFacilityDto attachFacilityId) {
        this.id = id;
        this.quantity = quantity;
        this.contractId = contractId;
        this.attachFacilityId = attachFacilityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ContractDto getContractId() {
        return contractId;
    }

    public void setContractId(ContractDto contractId) {
        this.contractId = contractId;
    }

    public AttachFacilityDto getAttachFacilityId() {
        return attachFacilityId;
    }

    public void setAttachFacilityId(AttachFacilityDto attachFacilityId) {
        this.attachFacilityId = attachFacilityId;
    }
}
