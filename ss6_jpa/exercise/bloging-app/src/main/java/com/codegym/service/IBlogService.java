package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> finAll();

    void saveBlog(Blog blog);

    Blog findById(int id);

    void deleteBlog(int id);
}
