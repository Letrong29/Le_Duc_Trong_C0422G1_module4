package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public List<Product> showList(String keySearch) {
        return this.iProductRepository.showList(keySearch);
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
        return this.iProductRepository.findById(id);
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

        this.iProductRepository.update(product);
    }

    @Override
    public void delete(Product product) {
        this.iProductRepository.delete(product);
    }

}
