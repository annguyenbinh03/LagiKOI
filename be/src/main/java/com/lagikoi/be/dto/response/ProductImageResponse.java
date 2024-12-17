package com.lagikoi.be.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductImageResponse {
    Integer id;
    String imageUrl;
    Integer displayOrder;
}
