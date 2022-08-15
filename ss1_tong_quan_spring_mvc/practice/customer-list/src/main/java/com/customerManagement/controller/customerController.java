package com.customerManagement.controller;

import com.customerManagement.model.Customer;
import com.customerManagement.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class customerController {

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/customer")
    public String showList(Model model) {
        List<Customer> customerList = iCustomerService.showList();
        model.addAttribute("customerList", customerList);
        return "list";
    }

    @GetMapping("/customerInfo")
    public String showInfo(@RequestParam int id, Model model) {
        Customer customer = this.iCustomerService.findCustomerById(id);
        model.addAttribute("customer",customer);
        return "info";
    }
}
