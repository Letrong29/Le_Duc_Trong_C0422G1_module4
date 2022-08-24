package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping(value = {"/home", ""})
    public String goHome(@PageableDefault(size = 4) Pageable pageable,
                         @RequestParam Optional<String> keySearch,
                         Model model) {

        String keyVal = keySearch.orElse("");

        model.addAttribute("productList",
                this.iProductService.findAllByNameContaining(keyVal, pageable));

        return "home";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {

        model.addAttribute("product", new Product());

        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product,
                       RedirectAttributes redirectAttributes) {

        this.iProductService.save(product);

        redirectAttributes.addAttribute("msg",
                "successfully added new");

        return "redirect:/product/home";
    }

    @GetMapping("/edit")
    public String goEdit(@RequestParam int id, Model model) {

        model.addAttribute("product",
                this.iProductService.findById(id));

        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product,
                         RedirectAttributes redirectAttributes) {

        this.iProductService.update(product);

        redirectAttributes.addAttribute("msg",
                "successfully update");

        return "redirect:/product/home";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id) {

        Product product = iProductService.findById(id);

        this.iProductService.delete(product);

        return "redirect:/product/home";
    }

    @GetMapping("/detail")
    public String goDetail(@RequestParam int id, Model model) {

        model.addAttribute("product",
                this.iProductService.findById(id));

        return "detail";
    }

}
