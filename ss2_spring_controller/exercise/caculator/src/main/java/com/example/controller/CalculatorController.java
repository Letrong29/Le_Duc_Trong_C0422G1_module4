package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String goCalculator() {
        return "/calculator";
    }

    @PostMapping("/count")
    public String count(@RequestParam Double number1,
                        Double number2,
                        String operator,
                        Model model) {

        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);

        try {
            model.addAttribute("result",
                    this.iCalculatorService.calculator(number1, number2, operator));
        } catch (ArithmeticException e) {
            model.addAttribute("message", "cannot be divided by 0");
        }

        return "calculator";
    }
}
