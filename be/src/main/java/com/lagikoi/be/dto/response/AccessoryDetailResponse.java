package com.lagikoi.be.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccessoryDetailResponse {
    Integer id;
    String name;
    String description;
    BigDecimal price;
    Integer stock;
    String brand;
    Integer viewCount;
    String category;
    List<ProductImageResponse> images;

    public AccessoryDetailResponse(Integer id, String name, String description, BigDecimal price, Integer stock,
                                   String brand, Integer viewCount,
                                   String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.brand = brand;
        this.viewCount = viewCount;
        this.category = category;
    }
}
