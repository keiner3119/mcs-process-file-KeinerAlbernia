package com.main.persistence.repositories;

import com.main.persistence.base.GenericRepository;
import com.main.persistence.entities.Category;
import com.main.persistence.irepositories.ICategoryRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository extends GenericRepository<Category> implements ICategoryRepository {

    public CategoryRepository(EntityManager entityManager) {
        super(Category.class, entityManager);
    }
}