package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "Iphone 13", 15000, "Apple",
                "", "New"));
        productMap.put(2, new Product(2, "Iphone 12", 10000, "Apple",
                "https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcSBr0UnNjlhgLr3SXaL6sSU_p0zcMPBSbZ4fqiOG1A377RF3xryLhw9Ph79d798fafbS4j76cn3Vm4&usqp=CAc", "New"));
        productMap.put(3, new Product(3, "Iphone 11", 8000, "Apple",
                "https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcQ9vPeqmiLOwgKZibXXynFmkPMcxNSLuMOHcsohIIErb72nytKe_o7zo_jpSagXTPOuNXpV2fJ_5wI&usqp=CAc", "New"));
        productMap.put(4, new Product(4, "Iphone X", 7000, "Apple",
                "", "New"));
        productMap.put(5, new Product(5, "Iphone XS Max", 8000, "Apple",
                "", "New"));
    }

    @Override
    public List<Product> showList() {
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(
                "select p from Product p", Product.class);

        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();

        BaseRepository.entityManager.persist(product);

        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {

        return BaseRepository.entityManager.find(Product.class, id);

    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();

        BaseRepository.entityManager.merge(product);

        entityTransaction.commit();
    }

    @Override
    public void delete(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();

        BaseRepository.entityManager.remove(product);

        entityTransaction.commit();

    }

    @Override
    public List<Product> search(String keySearch) {

        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(
                "select p from Product p where p.name like concat('%', :keySearch, '%') ", Product.class);

        query.setParameter("keySearch", keySearch);

        return query.getResultList();
    }
}
