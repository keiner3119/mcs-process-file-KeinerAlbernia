package com.main.persistence.commands;

import com.main.persistence.contracts.IUnityOfWork;
import com.main.persistence.dtos.CreateImagenToCategoryRequestDto;
import com.main.persistence.entities.Category;
import com.main.persistence.entities.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateImageToCategoryCommand {
    private final IUnityOfWork _unityOfWork;

    @Autowired
    public CreateImageToCategoryCommand(IUnityOfWork unityOfWork) {
        this._unityOfWork = unityOfWork;
    }

    @Transactional
    public void handle(CreateImagenToCategoryRequestDto request) {
        try {
            Category category = this._unityOfWork.categoryRepository()
                .findById(request.category.getId()).get();
            String pathImage = this._unityOfWork.imageRepository().saveInPath(
                request.imagenBase64);
            Image image = new Image(pathImage);
            category.setImagen(image);
            this._unityOfWork.categoryRepository().update(category);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}