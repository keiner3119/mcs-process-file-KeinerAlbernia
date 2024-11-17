package com.main.persistence.entities;

import com.main.persistence.utilities.Constants;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Data
@Table(name = Constants.TABLE_NAME_CATEGORY)
public class Category {

    public Category() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Constants.COLUMN_NAME_ID_CATEGORY)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = Constants.COLUMN_NAME_IMAGEN_IN_CATEGORY)
    private Image imagen;

    @Column(name = Constants.COLUMN_NAME_NOMBRE_CATEGORY)
    private String nombre;

    @Column(name = Constants.COLUMN_NAME_DESCRIPCION_CATEGORY)
    private String descripcion;

    @OneToMany(mappedBy = Constants.PROPERTY_NAME_OF_CATEGORY, cascade = CascadeType.ALL,
        orphanRemoval = Constants.VALUE_TRUE)
    private List<Product> products;
}