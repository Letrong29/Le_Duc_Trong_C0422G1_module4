package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ICartService;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@SessionAttributes(value = "cart")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICartService iCartService;

    @ModelAttribute("cart")
    public Map<Product, Integer> cart() {
        return new HashMap<>();
    }

    @GetMapping("/shop")
    public String showShop(Model model) {

        model.addAttribute("products",
                this.iProductService.findAll());

        return "shop";
    }

    @GetMapping("/detail")
    public String goDetail(@RequestParam Long id, Model model) {

        Product product = this.iProductService.findById(id).orElse(null);

        if (product == null) {
            return "error.404";
        }

        model.addAttribute("product", product);

        return "detail";
    }

    @GetMapping(value = {"/add"})
    public String addToCart(@RequestParam(defaultValue = "0") Long id,
                            @SessionAttribute Map<Product, Integer> cart,
                            String expression,
                            Model model) {

        Optional<Product> productOptional = this.iProductService.findById(id);

        if (!productOptional.isPresent()) {
            return "error.404";
        }

        this.iCartService.changeCart(cart,id,expression);

        model.addAttribute("total",
                this.iCartService.total(cart));

        model.addAttribute("cart", cart);

        return "cart";
    }

    @GetMapping("/remove")
    public String removeToCart(@SessionAttribute Map<Product, Integer> cart,
                               @RequestParam Long id,
                               Model model ){

        Product product = this.iProductService.findById(id).orElse(null);

        cart.remove(product);

        model.addAttribute("total",
                this.iCartService.total(cart));

        model.addAttribute("cart", cart);

        return "cart";
    }
}
