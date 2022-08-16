package com.example.controller;

import com.example.service.impl.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CurrencyController {
    @Autowired
    private CurrencyService currencyConversionService;

    @GetMapping("/")
    public String showFormCurrencyConversion() {
        return "/conversion-form";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam String usd, Model model) {
        Map<String, String> errorMap = this.currencyConversionService.validate(usd);
        double result;
        model.addAttribute("usd", usd);
        if (errorMap.isEmpty()) {
            result = this.currencyConversionService.convert(usd);
            model.addAttribute("result", result);
        } else {
            model.addAttribute("errUSD", errorMap.get("errUSD"));
        }
        return "/conversion-form";
    }
}
