package com.example.controller;

import com.example.service.CurrencyConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CurrencyConversion {
    CurrencyConversionService currencyConversionService = new CurrencyConversionService();

    @GetMapping("/")
    public String showFormCurrencyConversion(){
        return "/conversion-form";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam String usd, Model model){
        Map<String, String> errorMap = this.currencyConversionService.validate(usd);
        double result;
        model.addAttribute("usd",usd);
        if (errorMap.isEmpty()){
            result = Double.parseDouble(usd) * 23000;
            model.addAttribute("result",result);
        }else {
            model.addAttribute("errUSD",errorMap.get("errUSD"));
        }

        return "/conversion-form";
    }
}
