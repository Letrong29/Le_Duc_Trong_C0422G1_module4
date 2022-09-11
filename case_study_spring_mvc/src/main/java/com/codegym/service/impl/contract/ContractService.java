package com.codegym.service.impl.contract;

import com.codegym.model.contract.Contract;
import com.codegym.repository.contract.IContractRepository;
import com.codegym.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return this.iContractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(int id) {
        return this.iContractRepository.findById(id).orElse(new Contract());
    }

    @Override
    public void save(Contract contract) {
        this.iContractRepository.save(contract);
    }

    @Override
    public void remove(int id) {
        this.iContractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findAllByEndDateGreaterThan(String now, Pageable pageable) {
        return this.iContractRepository.findAllByEndDateGreaterThan(now, pageable);
    }
}
