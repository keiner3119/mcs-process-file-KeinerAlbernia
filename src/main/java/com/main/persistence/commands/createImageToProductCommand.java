package com.main.persistence.commands;

import com.main.persistence.contracts.IUnityOfWork;
import com.main.persistence.dtos.CreateImagenToProductRequestDto;
import com.main.persistence.entities.Image;
import com.main.persistence.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class createImageToProductCommand {
    private final IUnityOfWork _unityOfWork;

    @Autowired
    public createImageToProductCommand(IUnityOfWork unityOfWork) {
        this._unityOfWork = unityOfWork;
    }

    @Transactional
    public void handle(CreateImagenToProductRequestDto request) {
        try {
            Product product = this._unityOfWork.productRepository()
                .findById(request.product.getId()).get();

            String pathImage = this._unityOfWork.imageRepository().saveInPath(
                request.imagenBase64);

            Image image = new Image(pathImage);
            product.setImagen(image);

            this._unityOfWork.productRepository().update(product);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}