package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public List<Blog> findAll() {
        return this.iBlogRepository.findAll();
    }

    @Override
    public Page<Blog> finByName(String title, Pageable pageable) {
        return this.iBlogRepository.findAllByTitleContaining(title, pageable);
    }

    @Override
    public List<Blog> findAllByCategory_Id(int id) {
        return this.iBlogRepository.findAllByCategory_Id(id);
    }

    @Override
    public void saveBlog(Blog blog) {

        blog.setCreateTime(LocalDateTime.now());

        this.iBlogRepository.save(blog);
    }

    @Override
    public Optional<Blog> findById(int id) {
        return this.iBlogRepository.findById(id);
    }

    @Override
    public void deleteBlog(int id) {
        this.iBlogRepository.deleteById(id);
    }
}
