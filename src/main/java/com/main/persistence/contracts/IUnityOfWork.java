package com.main.persistence.contracts;

import com.main.persistence.irepositories.ICategoryRepository;
import com.main.persistence.irepositories.IImageRepository;
import com.main.persistence.irepositories.IProductRepository;

public interface IUnityOfWork extends AutoCloseable {
    ICategoryRepository categoryRepository();
    IProductRepository productRepository();
    IImageRepository imageRepository();
}