package com.example.controller;

import com.example.service.ICondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentsController {

    @Autowired
    private ICondimentsService iCondimentsService;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("condimentsList",
                this.iCondimentsService.findALl());

        return "home";
    }

    @PostMapping("/saveCondiments")
    public String saveCondiments(@RequestParam String[] condiments, Model model) {

        model.addAttribute("yourCondimentList", condiments);

        return "condiments";
    }
}
