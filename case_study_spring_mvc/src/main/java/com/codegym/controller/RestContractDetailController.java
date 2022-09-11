package com.codegym.controller;

import com.codegym.model.contract.ContractDetail;
import com.codegym.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/RestContractDetail")
public class RestContractDetailController {

    @Autowired
    private IContractDetailService iContractDetailService;

    @GetMapping("/listContract")
    public ResponseEntity<List<ContractDetail>> findById(@RequestParam int id){

        List<ContractDetail> contractDetails = this.iContractDetailService.findAllByContractId(id);

        if (contractDetails.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(contractDetails,
                HttpStatus.OK);
    }
}
