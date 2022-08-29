package com.example.controller;

import com.example.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    @GetMapping("")
    public String goHome(Model model){

        model.addAttribute("person", null);

        return "home";
    }
}
