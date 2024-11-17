package com.main.persistence.base;

import com.main.persistence.contracts.IUnityOfWork;
import com.main.persistence.irepositories.ICategoryRepository;
import com.main.persistence.irepositories.IImageRepository;
import com.main.persistence.irepositories.IProductRepository;
import com.main.persistence.repositories.CategoryRepository;
import com.main.persistence.repositories.ImageRepository;
import com.main.persistence.repositories.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.function.Supplier;

@Service
public class UnityOfWork implements IUnityOfWork {
    @PersistenceContext
    private EntityManager _entityManager;
    private ICategoryRepository _categoryRepository;
    private IProductRepository _productRepository;
    private IImageRepository _imageRepository;

    @Autowired
    public UnityOfWork(EntityManager entityManager) {
        this._entityManager = entityManager;
    }

    public ICategoryRepository categoryRepository() {
        return categoryRepositorySupplier.get();
    }
    private final Supplier<ICategoryRepository> categoryRepositorySupplier =
        () -> _categoryRepository == null
            ? (_categoryRepository = new CategoryRepository(_entityManager))
            : _categoryRepository;

    public IProductRepository productRepository() {
        return productRepositorySupplier.get();
    }
    private final Supplier<IProductRepository> productRepositorySupplier =
        () -> _productRepository == null
            ? (_productRepository = new ProductRepository(_entityManager))
            : _productRepository;

    public IImageRepository imageRepository() {
        return imageRepositorySupplier.get();
    }
    private final Supplier<IImageRepository> imageRepositorySupplier =
        () -> _imageRepository == null
            ? (_imageRepository = new ImageRepository())
            : _imageRepository;

    @Override
    public void close() throws Exception {
    }
}