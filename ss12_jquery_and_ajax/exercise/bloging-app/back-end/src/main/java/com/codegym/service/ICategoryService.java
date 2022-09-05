package com.codegym.service;

import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    List<Category> findAll();

    Page<Category> findAllByNameContaining(String keySearch, Pageable pageable);

    Category saveCategory(Category category);

    Optional<Category> findById(int id);

    void deleteCategory(int id);
}
