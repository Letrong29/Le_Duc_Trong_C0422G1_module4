package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    List<Blog> findAll();

    Page<Blog> finByName(String title, Pageable pageable);

    List<Blog> findAllByCategory_Id(int id);

    void saveBlog(Blog blog);

    Optional<Blog> findById(int id);

    void deleteBlog(int id);
}
