package com.main.persistence.repositories;

import com.main.persistence.base.GenericRepository;
import com.main.persistence.entities.Product;
import com.main.persistence.irepositories.IProductRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends GenericRepository<Product> implements IProductRepository {

    public ProductRepository(EntityManager entityManager) {
        super(Product.class, entityManager);
    }
}