package com.codegym.controller;

import com.codegym.model.Employee;
import com.codegym.service.IDivisionService;
import com.codegym.service.IEducationDegreeService;
import com.codegym.service.IEmployeeService;
import com.codegym.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @Autowired
    private IPositionService iPositionService;

    @Autowired
    private IDivisionService iDivisionService;

    @GetMapping(value = {"/home", ""})
    public String goHome(@PageableDefault(size = 3)Pageable pageable,
                         @RequestParam Optional<String> keySearch,
                         Model model){
        String keyVal = keySearch.orElse("");

        model.addAttribute("employeeAdd", new Employee());

        model.addAttribute("employees",
                this.iEmployeeService.findAllByNameContaining(keyVal, pageable));

        model.addAttribute("educationDegrees",
                this.iEducationDegreeService.findAll());

        model.addAttribute("positions",
                this.iPositionService.findAll());

        model.addAttribute("divisions",
                this.iDivisionService.findAll());

        model.addAttribute("keySearch", keyVal);

        return "employee-list";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee,
                               RedirectAttributes redirectAttributes){

        this.iEmployeeService.save(employee);

        redirectAttributes.addFlashAttribute("message",
                "successfully added new");

        return "redirect:/employee/home";
    }
}
