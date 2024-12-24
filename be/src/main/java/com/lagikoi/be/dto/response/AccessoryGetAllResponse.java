package com.lagikoi.be.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccessoryGetAllResponse {
    Integer id;
    String name;
    String description;
    BigDecimal price;
    Integer stock;
    String brand;
    Integer viewCount;
    String category;
    String primaryImageUrl;
}
