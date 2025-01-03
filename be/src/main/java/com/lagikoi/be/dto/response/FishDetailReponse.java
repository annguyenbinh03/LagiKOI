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
public class FishDetailReponse {
    Integer id;
    //Fish code, #001, #002
    String code;
    String name;
    String description;
    BigDecimal price;
    Integer stock;
    Integer yob;
    String gender;
    String size;
    String farmName;
    Integer viewCount;
    String category;
    List<ProductImageResponse> images;

    public FishDetailReponse(Integer id, String name, String description, BigDecimal price, Integer stock,
                             Integer yob, String gender, String size, String farmName, Integer viewCount,
                              String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.yob = yob;
        this.gender = gender;
        this.size = size;
        this.farmName = farmName;
        this.viewCount = viewCount;
        this.category = category;
    }
}
