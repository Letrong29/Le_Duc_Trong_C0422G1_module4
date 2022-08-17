package com.example.controller;

import com.example.model.Email;
import com.example.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class EmailController {

    @Autowired
    private IEmailService iEmailService;

    @GetMapping("/")
    public String goSettings(Model model) {

        model.addAttribute("languages", iEmailService.showLanguagesList());

        model.addAttribute("sizePage", iEmailService.showPageSizeList());

        model.addAttribute("email", new Email());

        return "settings";
    }

    @GetMapping("/update")
    public String update(@ModelAttribute Email email, Model model) {

        model.addAttribute("email", email);

        return "detail";
    }

}
