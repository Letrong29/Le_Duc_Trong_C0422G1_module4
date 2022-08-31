package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/create")
    public String goCreateCategory(Model model,
                                   @PageableDefault(size = 3)Pageable pageable,
                                   @RequestParam Optional<String> keySearch) {

        String keyVal = keySearch.orElse("");

        model.addAttribute("category", new Category());

        model.addAttribute("categorys",
                this.iCategoryService.findAllByNameContaining(keyVal, pageable));

        model.addAttribute("keySearch", keyVal);

        return "category-create";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {

        this.iCategoryService.saveCategory(category);

        redirectAttributes.addFlashAttribute("smg",
                "successfully added new category");

        return "redirect:/category/create";
    }

    @GetMapping("/edit")
    public String goEditForm(@RequestParam int id, Model model){

        model.addAttribute("category",
                this.iCategoryService.findById(id));

        return "category-edit";
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestParam int senId){

        this.iCategoryService.deleteCategory(senId);

        return "redirect:/category/create";
    }
}
