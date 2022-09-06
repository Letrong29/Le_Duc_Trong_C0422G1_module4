package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public Page<Blog> finByName(String title, Pageable pageable) {
        return this.iBlogRepository.findAllByTitleContaining(title, pageable);
    }

    @Override
    public void saveBlog(Blog blog) {

        blog.setCreateTime(LocalDateTime.now());

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
