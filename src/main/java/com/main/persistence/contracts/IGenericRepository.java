package com.main.persistence.contracts;

import java.util.Optional;
import java.util.UUID;

public interface IGenericRepository<T> {
    Optional<T> findById(UUID id);
    void update(T entity);
}