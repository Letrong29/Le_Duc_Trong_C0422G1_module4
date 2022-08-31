package com.codegym.controller;

import com.codegym.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @GetMapping("/home")
    public String goHome(@PageableDefault(size = 3)Pageable pageable,
                         @RequestParam Optional<String> keySearch,
                         Model model){

        String keyVal = keySearch.orElse("");

        model.addAttribute("contracts",
                this.iContractService.findAll(pageable));

        return "contract-list";
    }
}
