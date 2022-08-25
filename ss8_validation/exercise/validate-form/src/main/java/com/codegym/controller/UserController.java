package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/form")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String goForm(Model model){

        model.addAttribute("userDto", new UserDto());

        return "form";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute @Validated UserDto userDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes){

        new UserDto().validate(userDto, bindingResult);

        if (bindingResult.hasErrors()){
            return "form";
        }

        User user = new User();
        BeanUtils.copyProperties(userDto, user);

        this.iUserService.saveUser(user);
        redirectAttributes.addFlashAttribute("msg",
                "Sign Up Success");

        return "redirect:/form";
    }
}
