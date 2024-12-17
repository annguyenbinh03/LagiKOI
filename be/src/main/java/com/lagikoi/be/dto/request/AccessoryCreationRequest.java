package com.lagikoi.be.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.Instant;

public class AccessoryCreationRequest {
    @Size(max = 255, message = "FISH_CREATION_NAME_SIZE")
    @NotBlank(message = "Name cannot be null!")
    String name;
    String description;
    @NotNull(message = "Price cannot be null!")
    BigDecimal price;
    @Min(value = 0, message = "Stock can not smaller than 0")
    Integer stock;
    Instant createdAt; //It should be null, mapper will handle it
    @NotNull(message = "Accessory category cannot be null!")
    String category;

}
