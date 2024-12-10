package com.lagikoi.be.dto.request;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class FishCategoryCreationRequest {
    @NotEmpty(message = "Fish category name cannot be empty!")
    String name;
    String description;
}
