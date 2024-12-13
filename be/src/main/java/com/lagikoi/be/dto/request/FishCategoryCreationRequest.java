package com.lagikoi.be.dto.request;


import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FishCategoryCreationRequest {
    @NotEmpty(message = "Fish category name cannot be empty!")
    String name;
    String description;
}
