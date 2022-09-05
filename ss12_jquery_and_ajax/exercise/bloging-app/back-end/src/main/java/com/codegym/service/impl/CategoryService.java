package com.codegym.service.impl;

import com.codegym.model.Category;
import com.codegym.repository.ICategoryRepository;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;


    @Override
    public List<Category> findAll() {
        return this.iCategoryRepository.findAll();
    }

    @Override
    public Page<Category> findAllByNameContaining(String keySearch, Pageable pageable) {
        return this.iCategoryRepository.findAllByNameContaining(keySearch, pageable);
    }

    @Override
    public Category saveCategory(Category category) {
        return this.iCategoryRepository.save(category);
    }

    @Override
    public Optional<Category> findById(int id) {
        return this.iCategoryRepository.findById(id);
    }

    @Override
    public void deleteCategory(int id) {
        this.iCategoryRepository.deleteById(id);
    }
}
