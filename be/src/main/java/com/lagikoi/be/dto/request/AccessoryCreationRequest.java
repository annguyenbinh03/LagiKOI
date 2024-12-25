package com.lagikoi.be.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccessoryCreationRequest {
    @Size(max = 255, message = "ACCESSORY_CREATION_NAME_SIZE")
    @NotBlank(message = "Name cannot be null!")
    String name;
    String description;
    @Min(value = 0, message = "Price can not smaller than 0")
    @NotNull(message = "Price cannot be null!")
    BigDecimal price;
    @Min(value = 0, message = "Stock can not smaller than 0")
    Integer stock;
    @NotNull(message = "Brand name cannot be null!")
    String brand;
    @NotNull(message = "Accessory category cannot be null!")
    String category;
    @NotNull(message = "Fish images cannot be null")
    List<ProductImageCreationRequest> images;
}
