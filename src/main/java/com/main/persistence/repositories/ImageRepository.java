package com.main.persistence.repositories;

import com.main.persistence.irepositories.IImageRepository;
import com.main.persistence.utilities.Constants;
import org.springframework.stereotype.Repository;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Base64;

@Repository
public class ImageRepository implements IImageRepository {

    public ImageRepository() {
    }

    @Override
    public String saveInPath(String imagenBase64) throws IOException {
        byte[] decodedBytes = Base64.getDecoder().decode(imagenBase64);

        String timestamp = new SimpleDateFormat(Constants.SIMPLE_DATE_FORMAT)
            .format(new Date());
        String fileName = Constants.VALUE_IMAGE + timestamp + Constants.VALUE_JPG;
        String directoryPath = Constants.PATH_IMAGES;
        String filePath = directoryPath + fileName;

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            fileOutputStream.write(decodedBytes);
        }

        return filePath;
    }
}