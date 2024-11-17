package com.main.persistence.entities;

import com.main.persistence.utilities.Constants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import java.util.UUID;

@Getter
@Entity
@Data
@Table(name = Constants.TABLE_NAME_IMAGEN)
public class Image {

    public Image() {
    }

    public Image(String pathImage) {
        this.rutaImagen = pathImage;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Constants.COLUMN_NAME_ID_IMAGEN)
    private UUID id;

    @Column(name = Constants.COLUMN_NAME_RUTA_IMAGEN_IMAGEN)
    private String rutaImagen;
}