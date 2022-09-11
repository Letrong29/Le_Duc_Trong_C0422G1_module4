package com.codegym.controller;

import com.codegym.model.contract.Contract;
import com.codegym.model.facility.Facility;
import com.codegym.service.IAttachFacilityService;
import com.codegym.service.IContractService;
import com.codegym.service.IFacilityService;
import com.codegym.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @Autowired
    private IFacilityService iFacilityService;

    @GetMapping("/home")
    public String goHome(@PageableDefault(size = 3)Pageable pageable,
                         @RequestParam Optional<String> keySearch,
                         Model model){

        String keyVal = keySearch.orElse("");

        model.addAttribute("contracts",
                this.iContractService.findAll(pageable));

        model.addAttribute("attachFacilityList",
                this.iAttachFacilityService.findAll());

        return "contract-list";
    }

    @GetMapping("/findById")
    public String findById(@RequestParam int id,
                           Model model){

        model.addAttribute("contract",
                this.iContractService.findById(id));

        return "/customer-has-contract";
    }

    //show form edit ở bảng khách hàng đang sử dụng dịch vụ
    @GetMapping("/facilityNameEdit")
    public String goFacilityNameEdit(@RequestParam int id,
                                     Model model){

        model.addAttribute("facilityNameList",
                this.iFacilityService.showFacilityList());

        model.addAttribute("contract",
                this.iContractService.findById(id));

        return "facility-name-edit";
    }

    //update ở bảng khách hàng đang sử dụng dịch vụ
    @PostMapping("/facilityNameUpdate")
    public String updateFacilityName(@ModelAttribute Contract contract,
                                     RedirectAttributes redirectAttributes){

        Contract contractEdit = this.iContractService.findById(contract.getId());

        contractEdit.setFacilityId(contract.getFacilityId());

        this.iContractService.save(contractEdit);

        redirectAttributes.addFlashAttribute("message",
                "update success");

        return "redirect:/customer/list";
    }

    //delete ở bảng khách hàng đang sử dụng dịch vụ
    @PostMapping("/delete")
    public String deleteContract(@RequestParam int idDelete){

        this.iContractService.remove(idDelete);

        return "redirect:/customer/list";
    }
}
