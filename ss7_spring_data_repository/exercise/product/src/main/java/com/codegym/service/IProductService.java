package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {

    Page<Product> findAllByNameContaining(String keySearch, Pageable pageable);

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void delete(Product product);
}
