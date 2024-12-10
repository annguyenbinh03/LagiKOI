package com.lagikoi.be.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class FishCreationRequest {
    @NotBlank(message = "Name cannot be null!")
    String name;
    String description;
    @NotNull(message = "Price cannot be null!")
    BigDecimal price;
    @Min(value = 0, message = "Stock can not smaller than 0")
    Integer stock;
    @NotNull(message = "Age cannot be null!")
    String age;
    @NotNull(message = "Gener cannot be null!")
    String gender;
    @NotNull(message = "Size cannot be null!")
    String size;
    @NotNull(message = "Farm name cannot be null!")
    String farmName;
    @NotNull(message = "Fish category cannot be null!")
    String category;
    @NotNull(message = "Fish images cannot be null")
    List<String> imageUrls;
}
