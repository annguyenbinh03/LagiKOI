package com.lagikoi.be.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
public class FishImagesCreationRequest {
    @NotNull
    String imageUrl;
    @NotNull
    @Min(value = 1, message = "Display order cannot smaller than 1")
    Integer displayOrder;
    Instant createdAt; //It should be null, mapper will handle it
}
