package com.main.persistence.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.main.init.utilities.Constants;
import com.main.persistence.entities.Product;
import lombok.Data;

@Data
public class CreateImagenToProductRequestDto {
    @JsonProperty(Constants.VALUE_PRODUCT)
    public Product product;

    @JsonProperty(Constants.VALUE_IMAGEN_BASE64)
    public String imagenBase64;
}