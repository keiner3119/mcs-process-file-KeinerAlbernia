package com.main.persistence.entities;

import com.main.persistence.utilities.Constants;
import jakarta.persistence.*;

import java.util.UUID;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Data
@Table(name = Constants.TABLE_NAME_PRODUCT)
public class Product {

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Constants.COLUMN_NAME_ID_PRODUCT)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = Constants.COLUMN_NAME_CATEGORY_IN_PRODUCT)
    private Category categoria;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = Constants.COLUMN_NAME_IMAGEN_IN_PRODUCT)
    private Image imagen;

    @Column(name = Constants.COLUMN_NAME_PRECIO_PRODUCT)
    private String precio;

    @Column(name = Constants.COLUMN_NAME_CANTIDAD_PRODUCT)
    private String cantidad;

    @Column(name = Constants.COLUMN_NAME_BUSSINES_IN_PRODUCT)
    private String idBussines;

    @Column(name = Constants.COLUMN_NAME_DISPONIBLE_PRODUCT)
    private String disponible;

    @Column(name = Constants.COLUMN_NAME_DESCRIPCION_PRODUCT)
    private String descripcion;

    @Column(name = Constants.COLUMN_NAME_COMISION_PRODUCT)
    private int comision;

    @Column(name = Constants.COLUMN_NAME_ESTA_ACTIVO_PRODUCT)
    private Boolean estaActivo;
}