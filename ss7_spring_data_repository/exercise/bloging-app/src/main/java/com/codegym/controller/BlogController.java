package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
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
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = {"/home", ""})
    public String goHome(Model model,
                         @PageableDefault(size = 4) Pageable pageable,
                         @RequestParam Optional<String> keySearch) {

        String keyVal = keySearch.orElse("");

        model.addAttribute("blogs",
                this.iBlogService.finByName(keyVal, pageable));

        model.addAttribute("keySearch", keyVal);

        model.addAttribute("categorys",
                this.iCategoryService.findAll());

        return "blog-home";
    }

    @GetMapping("/create")
    public String goCreatBlog(Model model) {

        model.addAttribute("blog", new Blog());

        model.addAttribute("categorys",
                this.iCategoryService.findAll());

        return "blog-create";
    }

    @PostMapping("/save")
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {

        this.iBlogService.saveBlog(blog);

        redirectAttributes.addFlashAttribute("smg",
                "successfully added new blog");

        return "redirect:/blog";
    }

    @GetMapping("/read")
    public String goReadPage(@RequestParam int id, Model model) {

        model.addAttribute("blog",
                this.iBlogService.findById(id));

        return "blog-read";
    }

    @GetMapping("/edit")
    public String goEditForm(@RequestParam int id, Model model) {

        model.addAttribute("blog",
                this.iBlogService.findById(id));

        model.addAttribute("categorys",
                this.iCategoryService.findAll());

        return "/blog-edit";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam int senId) {

        this.iBlogService.deleteBlog(senId);

        return "redirect:/blog";
    }
}
