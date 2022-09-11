package com.codegym.service;

import com.codegym.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {

    List<ContractDetail> findAllByContractId(int id);
}
