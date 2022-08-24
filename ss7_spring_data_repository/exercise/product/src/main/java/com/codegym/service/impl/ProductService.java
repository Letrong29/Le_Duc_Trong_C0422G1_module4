package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public Page<Product> findAllByNameContaining(String keySearch, Pageable pageable) {
        return this.iProductRepository.findAllByNameContaining(keySearch, pageable);
    }

    @Override
    public void save(Product product) {

        String link = "";
        try {
            link = product.getImg().getOriginalFilename();
            FileCopyUtils.copy(product.getImg().getBytes(),
                    new File("E:\\up\\" + link));

        } catch (IOException e) {
            e.printStackTrace();
        }

        product.setLink(link);
        this.iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return this.iProductRepository.getById(id);
    }

    @Override
    public void update(Product product) {

        String link = "";

        try {
            link = product.getImg().getOriginalFilename();
            FileCopyUtils.copy(product.getImg().getBytes(),
                    new File("E:\\up\\" + link));

        } catch (IOException e) {
            e.printStackTrace();
        }

        product.setLink(link);

        this.iProductRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        this.iProductRepository.delete(product);
    }

}
