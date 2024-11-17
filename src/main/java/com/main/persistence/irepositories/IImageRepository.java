package com.main.persistence.irepositories;

import java.io.IOException;

public interface IImageRepository {
    String saveInPath(String imagenBase64) throws IOException;
}