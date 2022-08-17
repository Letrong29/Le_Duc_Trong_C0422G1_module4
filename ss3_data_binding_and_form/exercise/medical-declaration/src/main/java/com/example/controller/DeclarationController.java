package com.example.controller;

import com.example.model.MedicalDeclaration;
import com.example.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DeclarationController {

    @Autowired
    private IDeclarationService iDeclarationService;

    @GetMapping("/")
    public String showList(Model model) {

        model.addAttribute("medicalDeclarationList", this.iDeclarationService.findAll());

        return "list";
    }

    @GetMapping("/showFormAdd")
    public String goMedicalDeclaration(Model model) {

        model.addAttribute("yearOfBirthList", iDeclarationService.showYearOfBirthList());

        model.addAttribute("genderList", iDeclarationService.showGenderList());

        model.addAttribute("vehiclesList", iDeclarationService.showVehiclesList());

        model.addAttribute("dayList", iDeclarationService.showDayList());

        model.addAttribute("monthList", iDeclarationService.showMonthList());

        model.addAttribute("yearList", iDeclarationService.showYearList());

        model.addAttribute("MedicalDeclaration", new MedicalDeclaration());

        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute MedicalDeclaration medicalDeclaration, RedirectAttributes redirectAttributes) {

        this.iDeclarationService.addNew(medicalDeclaration);

        redirectAttributes.addFlashAttribute("msg",
                "Them moi thanh cong");

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {

        model.addAttribute("medicalDeclaration",
                this.iDeclarationService.findById(id));

        model.addAttribute("yearOfBirthList", iDeclarationService.showYearOfBirthList());

        model.addAttribute("genderList", iDeclarationService.showGenderList());

        model.addAttribute("vehiclesList", iDeclarationService.showVehiclesList());

        model.addAttribute("dayList", iDeclarationService.showDayList());

        model.addAttribute("monthList", iDeclarationService.showMonthList());

        model.addAttribute("yearList", iDeclarationService.showYearList());

        return "edit";
    }

    @PostMapping("update/{id}")
    public String update(@ModelAttribute MedicalDeclaration medicalDeclaration, @PathVariable int id) {

        this.iDeclarationService.update(id, medicalDeclaration);

        return "redirect:/";
    }
}
