package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest-blog")
public class BlogRestController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/list")
    public ResponseEntity<List<Blog>> goList(){
        List<Blog> blogs = this.iBlogService.findAll();

        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/by-category")
    public ResponseEntity<List<Blog>> goListBlogByCategory(@RequestParam int id){
        List<Blog> blogs = this.iBlogService.findAllByCategory_Id(id);

        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<Blog> goDetail(@RequestParam int id){
        Optional<Blog> blogOptional = this.iBlogService.findById(id);

        if (!blogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }


}
