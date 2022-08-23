package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> showList(String keySearch) {

        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(
                "select p from Product p where p.name like :keySearch ", Product.class);

        query.setParameter("keySearch", "%" + keySearch + "%");

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


}
