package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> finAll() {
        return this.iBlogRepository.findAll();
    }

    @Override
    public void saveBlog(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return this.iBlogRepository.getById(id);
    }

    @Override
    public void deleteBlog(int id) {
        this.iBlogRepository.deleteById(id);
    }
}
