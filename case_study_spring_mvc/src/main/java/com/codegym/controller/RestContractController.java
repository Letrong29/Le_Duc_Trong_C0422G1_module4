package com.codegym.controller;

import com.codegym.model.contract.Contract;
import com.codegym.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/RestContract")
public class RestContractController {

    @Autowired
    private IContractService iContractService;


}
