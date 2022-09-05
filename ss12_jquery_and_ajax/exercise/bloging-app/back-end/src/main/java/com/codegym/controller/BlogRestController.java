package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/rest-blog")
public class BlogRestController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/list")
    public ResponseEntity<Page<Blog>> goList(@PageableDefault(size = 5)Pageable pageable,
                                             Optional<String> title){

        String titleVal = title.orElse("");

        Page<Blog> blogs = this.iBlogService.finByName(titleVal, pageable);

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
