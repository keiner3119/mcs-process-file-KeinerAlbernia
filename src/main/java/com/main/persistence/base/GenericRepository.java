package com.main.persistence.base;

import com.main.persistence.contracts.IGenericRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public class GenericRepository<T> implements IGenericRepository<T> {

    protected EntityManager entityManager;
    private final Class<T> _entityType;

    protected GenericRepository(Class<T> entityType, EntityManager entityManager) {
        this._entityType = entityType;
        this.entityManager = entityManager;
    }

    @Override
    public Optional<T> findById(UUID id) {
        T entity = entityManager.find(_entityType, id);
        return Optional.ofNullable(entity);
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }
}