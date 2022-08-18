package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> showList();

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void delete(int id);

    List<Product> search(String keySearch);
}
