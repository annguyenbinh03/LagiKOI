package com.lagikoi.be.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FishGetAllResponse {
    Integer id;
    //Fish code, #001, #002
    String code;
    String name;
    String description;
    BigDecimal price;
    Integer stock;
    String age;
    String gender;
    String size;
    String farmName;
    Integer viewCount;
    String category;
    List<String> imageUrls;

    public FishGetAllResponse(Integer id, String name, String description, BigDecimal price, Integer stock,
                              String age, String gender, String size, String farmName, Integer viewCount,
                              String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.age = age;
        this.gender = gender;
        this.size = size;
        this.farmName = farmName;
        this.viewCount = viewCount;
        this.category = category;
    }
}
