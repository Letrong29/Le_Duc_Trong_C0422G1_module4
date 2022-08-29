package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.impl.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Map;

@Controller
public class ShoppingCartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/shopping-cart")
    public  String goCart(Model model,
                          @SessionAttribute Map<Product, Integer> cart){

        model.addAttribute("cart",cart);

        model.addAttribute("total",
                cartService.total(cart));

        return "cart";
    }
}
