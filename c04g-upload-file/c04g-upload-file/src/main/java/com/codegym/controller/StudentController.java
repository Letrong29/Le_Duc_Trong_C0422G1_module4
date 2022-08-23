package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping(value = "/student")
@Controller
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @GetMapping(value = "/list")
    public String goStudentList(Model model) {

        model.addAttribute("studentList",
                this.iStudentService.findAll());

        return "list_student";
    }

//    @GetMapping(value = "/list")
//    public String goStudentList(ModelMap modelMap) {
//
//        modelMap.addAttribute("studentList",
//                this.iStudentService.findAll());
//
//        return "list_student";
//    }

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    @GetMapping(value = {"/list", ""})
//    public ModelAndView goStudentList() {
//
//        ModelAndView modelAndView = new ModelAndView("list_student");
//
//        modelAndView.addObject("studentList",
//                this.iStudentService.findAll());
//
//        return modelAndView;
//    }

    @GetMapping(value = "/detail")
    public String goDetailStudent(@RequestParam int id,
                                  Model model) {

        model.addAttribute("studentObj",
                this.iStudentService.findById(id));

        return "detail_student";
    }

    @GetMapping(value = "/detail/{idStudent}")
    public String goDetailStudentPV(@PathVariable int idStudent,
                                  Model model) {

        model.addAttribute("studentObj",
                this.iStudentService.findById(idStudent));

        return "detail_student";
    }

    @GetMapping(value = "/create")
    public String goCreateStudent(Model model) {
        model.addAttribute("student",
                new Student());
        return "create_student";
    }

    @PostMapping(value = "/create")
    public String createStudent(@ModelAttribute Student student,
                                RedirectAttributes redirectAttributes) {
//        model.addAttribute("student", new Student());
        this.iStudentService.save(student);
        redirectAttributes.addFlashAttribute("msg",
                "Register successfully!");

        return "redirect:/student/list";
    }
}
