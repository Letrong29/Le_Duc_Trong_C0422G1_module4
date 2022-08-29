package com.codegym.service;

import com.codegym.model.Product;

import java.util.Map;

public interface ICartService {

    void changeCart(Map<Product,Integer> cart, Long id, String expression);

    double total(Map<Product,Integer> cart);
}
