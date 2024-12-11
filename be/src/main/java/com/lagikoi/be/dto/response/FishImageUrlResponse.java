package com.lagikoi.be.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class FishImageUrlResponse {
    Integer id;
    String imageUrl;
    Integer displayOrder;
}
