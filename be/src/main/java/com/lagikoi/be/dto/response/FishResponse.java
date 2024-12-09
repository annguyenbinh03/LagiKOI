package com.lagikoi.be.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FishResponse {
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
}
