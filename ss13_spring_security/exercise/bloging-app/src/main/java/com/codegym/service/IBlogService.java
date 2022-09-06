package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {

    Page<Blog> finByName(String title, Pageable pageable);

    void saveBlog(Blog blog);

    Blog findById(int id);

    void deleteBlog(int id);
}
