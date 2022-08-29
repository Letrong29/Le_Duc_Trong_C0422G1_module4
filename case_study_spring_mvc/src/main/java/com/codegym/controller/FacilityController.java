package com.codegym.controller;

import com.codegym.model.Facility;
import com.codegym.service.IFacilityService;
import com.codegym.service.IFacilityTypeService;
import com.codegym.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @GetMapping(value = {"/home",""})
    public String goFacilityList(@PageableDefault(size = 3)Pageable pageable,
                                 @RequestParam Optional<String> keySearch,
                                 Model model){

        String keyVal = keySearch.orElse("");

        model.addAttribute("facilitys",
                this.iFacilityService.findAllByNameContaining(keyVal, pageable));

        model.addAttribute("keySearch", keyVal);

        return "facility-list";
    }

    @GetMapping("/create")
    public String goCreateForm(Model model){

        model.addAttribute("facility", new Facility());

        model.addAttribute("facilityTypeList",
                this.iFacilityTypeService.findAll());

        model.addAttribute("rentTypeList",
                this.iRentTypeService.findAll());

        return "facility-create";
    }

    @PostMapping("/save")
    public String saveFacility(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes){

        this.iFacilityService.save(facility);

        redirectAttributes.addFlashAttribute("message",
                "successfully added new");

        return "redirect:/facility/home";
    }

    @GetMapping("/edit")
    public String goEditForm(@RequestParam int id, Model model){

        model.addAttribute("facility",
                this.iFacilityService.findById(id));

        model.addAttribute("facilityTypeList",
                this.iFacilityTypeService.findAll());

        model.addAttribute("rentTypeList",
                this.iRentTypeService.findAll());

        return "facility-edit";
    }

    @PostMapping("/update")
    public String updateFacility(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes){

        this.iFacilityService.save(facility);

        redirectAttributes.addFlashAttribute("message",
                "successfully update");

        return "redirect:/facility/home";
    }

    @PostMapping("/delete")
    public String deleteFacility(@RequestParam int facilityId){

        this.iFacilityService.deleteById(facilityId);

        return "redirect:/facility";
    }
}
