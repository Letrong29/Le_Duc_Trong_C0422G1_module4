package com.example.controller;

import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    IDictionaryService iDictionaryService;

    @GetMapping("/")
    public String home(){
        return "/index";
    }

    @GetMapping("/translate")
    public String goTranslate(){
        return "/translate";
    }

    @PostMapping("/trans")
    public String trans(@RequestParam String keySearch, Model model){
        String result = iDictionaryService.trans(keySearch);
        model.addAttribute("keySearch",keySearch);
        model.addAttribute("result", result);
        return "/translate";
    }
}
