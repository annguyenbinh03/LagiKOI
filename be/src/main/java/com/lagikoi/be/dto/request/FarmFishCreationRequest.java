package com.lagikoi.be.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FarmFishCreationRequest {
    @Size(max = 50)
    @NotBlank(message = "Farm name can not be blank")
    String name;
    String description;
}
