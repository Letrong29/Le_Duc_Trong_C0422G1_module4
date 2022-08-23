package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/blog")
    public String goHome(Model model){

        model.addAttribute("blogs",
                this.iBlogService.finAll());

        return "blog-home";
    }

    @GetMapping("/create")
    public String goCreatForm(Model model){

        model.addAttribute("blog", new Blog());

        return "blog-create";
    }

    @PostMapping("/save")
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){

        this.iBlogService.saveBlog(blog);

        redirectAttributes.addFlashAttribute("smg",
                "successfully added new");

        return "redirect:/blog";
    }

    @GetMapping("/read")
    public String goReadPage(@RequestParam int id, Model model){

        model.addAttribute("blog",
                this.iBlogService.findById(id));

        return "blog-read";
    }

    @GetMapping("/edit")
    public String goEditForm(@RequestParam int id, Model model){

        model.addAttribute("blog",
                this.iBlogService.findById(id));

        return "/blog-edit";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam int senId){

        this.iBlogService.deleteBlog(senId);

        return "redirect:/blog";
    }
}
