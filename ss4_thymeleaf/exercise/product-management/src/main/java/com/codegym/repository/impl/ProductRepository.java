package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "Iphone 13", 15000, "Apple",
                "https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcRZg-dI3SHXTfTJmLBTs9r6R2o1VEDlvT0yxpfl1EzPLuQg4c1dObL5DiP-Uhuz&usqp=CAc", "New"));
        productMap.put(2, new Product(2, "Iphone 12", 10000, "Apple",
                "https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcSBr0UnNjlhgLr3SXaL6sSU_p0zcMPBSbZ4fqiOG1A377RF3xryLhw9Ph79d798fafbS4j76cn3Vm4&usqp=CAc", "New"));
        productMap.put(3, new Product(3, "Iphone 11", 8000, "Apple",
                "https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcQ9vPeqmiLOwgKZibXXynFmkPMcxNSLuMOHcsohIIErb72nytKe_o7zo_jpSagXTPOuNXpV2fJ_5wI&usqp=CAc", "New"));
        productMap.put(4, new Product(4, "Iphone X", 7000, "Apple",
                "https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcRQILinlGLn50YbP7RrL7pa76DYOc8jTfDwhtt5Fjf0D7vaE3pw9CRlEuDhh8FLWcgyUqI15s-17w&usqp=CAc", "New"));
        productMap.put(5, new Product(5, "Iphone XS Max", 8000, "Apple",
                "https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcRQILinlGLn50YbP7RrL7pa76DYOc8jTfDwhtt5Fjf0D7vaE3pw9CRlEuDhh8FLWcgyUqI15s-17w&usqp=CAc", "New"));
    }

    @Override
    public List<Product> showList() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        int id = (int) (Math.random() * 1000);

        product.setId(id);

        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        for (Product p : productMap.values()) {
            if (id == p.getId()) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void delete(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> search(String keySearch) {
        List<Product> productList = new ArrayList<>();

        for (Product p : productMap.values()) {
            if (p.getName().toLowerCase().contains(keySearch.toLowerCase())) {
                productList.add(p);
            }
        }
        return productList;
    }
}
