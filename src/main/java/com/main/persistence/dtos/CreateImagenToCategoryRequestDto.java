package com.main.persistence.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.main.init.utilities.Constants;
import com.main.persistence.entities.Category;
import lombok.Data;

@Data
public class CreateImagenToCategoryRequestDto {
    @JsonProperty(Constants.VALUE_CATEGORY)
    public Category category;

    @JsonProperty(Constants.VALUE_IMAGEN_BASE64)
    public String imagenBase64;
}